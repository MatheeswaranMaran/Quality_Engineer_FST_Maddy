describe('Todo API Interception Tests', () => {

    it('should intercept GET /api/todos and load fixtures correctly', () => {
        // 1. Intercept the GET request and stub the response with our fixture file
        cy.intercept('GET', '/api/todos', { fixture: 'todos.json' }).as('getTodos');

        // 2. Visit the app (which should trigger the GET request on load)
        cy.visit('http://localhost:3000');

        // 3. Wait for the intercepted request to resolve
        cy.wait('@getTodos');

        // 4. Verify the UI renders the mock data from our fixture
        cy.get('[data-cy="todo-item"]').should('have.length', 2);
        cy.get('[data-cy="todo-text"]').first().should('contain.text', 'Learn Cypress Intercepts');
        cy.get('[data-cy="todo-text"]').last().should('contain.text', 'Build a real backend API');
    });

    it('should intercept POST /api/todos and verify the payload', () => {
        const newTodoText = 'Practice API Mocking';

        // 1. Intercept the POST request and mock a successful 201 response
        cy.intercept('POST', '/api/todos', {
            statusCode: 201,
            body: { id: 3, text: newTodoText, completed: false }
        }).as('postTodo');

        cy.visit('http://localhost:3000');

        // 2. Perform the UI action that triggers the POST
        cy.get('[data-cy="todo-input"]').type(newTodoText);
        cy.get('[data-cy="add-button"]').click();

        // 3. Wait for the POST request and verify the payload the frontend sent
        cy.wait('@postTodo').then((interception) => {
            // Check that the frontend sent the correct data to the backend
            expect(interception.request.body).to.deep.equal({
                text: newTodoText,
                completed: false
            });
        });

        // 4. Verify the UI updates 
        cy.get('[data-cy="todo-text"]').should('contain.text', newTodoText);
    });

    it('should handle a 500 server error on POST gracefully', () => {
        const failedTodoText = 'This will fail';

        // 1. Intercept the POST and force a 500 Internal Server Error
        cy.intercept('POST', '/api/todos', {
            statusCode: 500,
            body: { message: 'Internal Server Error' }
        }).as('postTodoError');

        cy.visit('http://localhost:3000');

        // 2. Trigger the action
        cy.get('[data-cy="todo-input"]').type(failedTodoText);
        cy.get('[data-cy="add-button"]').click();

        // 3. Wait for the failed request
        cy.wait('@postTodoError');

        // 4. Verify the error message appears in the UI
        // Note: You will need to build this error state into your React app!
        cy.get('[data-cy="error-message"]')
            .should('be.visible')
            .and('contain.text', 'Failed to add todo');

        // 5. Verify the item was NOT added to the list visually
        cy.get('[data-cy="todo-text"]').should('not.contain.text', failedTodoText);
    });
});
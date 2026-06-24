describe('Activity 2', () => {

    beforeEach(() => {
        cy.visit("/");
        cy.addTask("Task 1");
    })

    // Test function to verify the page is loaded
    it('verifying the page header', () => {
        cy.get('.text-3xl').should('have.text', 'Todo List');
        cy.log("Opened the page!")
    })

    // Test function to check the input field is present
    it('check whether input field is present', () => {
        cy.get('[data-cy="todo-input"]').should('be.visible');
    })

    // Test function to verifying the input
    it('add the input in the to do list', () => {
        cy.get('[data-cy="todo-text"]').should('contain', '1');
        cy.log("The task is added and present in the to do list")
    })

    // Test function to mark as complete
    it('mark as complete', () => {
        cy.get('[data-cy="todo-checkbox"]').check();
        cy.get('[data-cy="todo-checkbox"]').should('be.checked');
        cy.log("The task is marked as complete");
    })

    // Test function to delete the function
    it('delete the task', () => {
        cy.get('[data-cy="delete-button"]').click();
        cy.get('[data-cy="empty-state"]').should('be.visible');
    })
})
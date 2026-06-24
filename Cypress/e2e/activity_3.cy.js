describe("Activity 3", () => {

    beforeEach(() => {
        cy.visit("/");

        // Adding the tasks
        cy.addTask('Task 1');
        cy.addTask('Task 2');
        cy.addTask('Task 3');
    })


    it('Verify the length of the tasks', () => {
        // Verify
        cy.getData("todo-item").should('have.length', 3);
    })

    it('Complete the tasks', () => {
        // Checking the checkboxes
        cy.completeTask('todo-item', 0);
        cy.completeTask('todo-item', 1);

        // Verify
        cy.verifyChecked('todo-checkbox', 0, 'be.checked');
        cy.verifyChecked('todo-checkbox', 1, 'be.checked');
        cy.verifyChecked('todo-checkbox', 2, 'not.be.checked');

        // Verify the tasks are completed
        cy.getData("todo-count").should('contain', 'Completed: 2');
    })

    it('Delete tasks', () => {
        // Delete the task
        cy.deleteTask(2);

        // Verify
        cy.getData("todo-item").should('have.length', 2);
    })

})
describe('My First Test', () => {

  it('opens the app', () => {
    cy.visit('http://localhost:3000');
  })

  // Test function to verify the page is loaded
  it('verifying the page header', () => {
    cy.visit('http://localhost:3000');
    cy.contains('Todo List');
  })

  // Test function to check the input field is present
  it('check whether input field is present', () => {
    cy.visit('http://localhost:3000');
    cy.get('[data-cy="todo-input"]').should('be.visible');
  })

  
})
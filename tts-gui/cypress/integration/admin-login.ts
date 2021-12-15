describe('Login as admin', () => {

    it('Click Sign in', () => {
        cy.get('#loginNavButton').click();
        cy.get('#emailInput').type('admin')
        cy.get('#passwordInput').type('adminadmin')
        cy.get('#submitButton').click()
        cy.contains('Successfully logged in.').should('exist')
        cy.wait(1000)
    });
});
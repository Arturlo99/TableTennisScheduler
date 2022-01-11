describe('Registration test', () => {
    before(() => {
        cy.visit('/')
    });

    it('Click sign up button', () => {
        cy.get('#registerNavButton').click()
    });

    let email = (Math.random() * 10000).toString(10).substring(0, 4).replace('.', "") + '@' + 'gmail.com'
    it('Fill register form', () => {
        cy.get('#nameInput').type('name')
        cy.get('#lastNameInput').type('lastName')
        cy.get('#emailInput').type(email)
        cy.get('#passwordInput').type('12345678')
        cy.get('#confirmPasswordInput').type('12345678')
        cy.get('#submitButton').click()
        cy.contains('Successfully registered!').should('exist')
        cy.url().should('include', '/')
    });

    it('Sign in', () => {
        cy.get('#loginNavButton').click()
        cy.get('#emailInput').type(email)
        cy.get('#passwordInput').type('12345678')
        cy.get('#submitButton').click()
        cy.contains('Successfully logged in.').should('exist')
        cy.wait(1000)
    });
});

describe('Create new tournament', () => {
    it('Fill the form', () => {
        cy.get('#tournamentsNavButton').click();
        cy.get('#createNewTournamentButton').scrollIntoView().should('be.visible')
        cy.get('#createNewTournamentButton').click()
        cy.get('#nameInput').type('Test tournament')
        cy.get('#cityInput').type('Wrocław')
        cy.get('#streetInput').type('Grabiszyńska 35b')
        cy.get('#datePicker').click()
        cy.get('.mat-calendar-next-button').click();
        cy.contains('24').click();
        cy.get('#hourInput').type('16:00')
        cy.get('mat-select[formControlName=maxPlayers]').click().get('mat-option').contains('12').click();
        cy.get('#submitButton').click()
        cy.contains('Successfully created new tournament!').should('exist')
        cy.url().should('include', '/')
    });
});
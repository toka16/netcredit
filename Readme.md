## Overview

Create a web application in which user can register and view and edit his profile.

### Registration fields:

* Name
* Phone number
* Birthdate
* Monthly salary
* Current remaining liabilities
* Avatar (optional but will count as a small bonus for the applicant) 

When user registers they must be redirected to the profile view with the information they specified during registration + allowed credit limit which should be calculated using formula :

    AGE_IN_YEARS * 10 + salary - liabilities

For clients with age < `18` or > `65` credit limit should be `0`

Clients with age < `18` should not be able to register at all.

Clients also must be able to edit their profile.

## Technical requirements

Backend Platform: Spring Boot

Frontend Platform: HTML5, AngularJS

RDBMS: any SQL via JPA

Project Management: Gradle or Maven

Additional requirements:

* All fields must be validated
* Birthdate should only be editable once
* Tests

<%@ page import="academy.user.AcademyUser; academy.user.AcademyUser" %>

<form:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   required="true"
                   field="name">
    <g:textField name="name" required="required" value="${userInstance?.name}"/>
</form:field>

<form:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   required="true"
                   field="surname">
    <g:textField name="surname" required="required" value="${userInstance?.surname}"/>
</form:field>

<form:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   field="email">
    <g:textField name="email" value="${userInstance?.email}"/>
</form:field>

<form:field bean="${userInstance}"
                   originalEntity="${academy.user.AcademyUser}"
                   field="phoneNumber">
    <g:textField name="phoneNumber" value="${userInstance?.phoneNumber}"/>
</form:field>

<form:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   field="englishLevel">
    <g:textField name="englishLevel" value="${userInstance?.englishLevel}"/>
</form:field>

<form:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   required="true"
                   field="password">
    <g:passwordField name="password" required="" value="${userInstance?.password}"/>
</form:field>

<form:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   required="true"
                   field="passwordConfirm">
    <g:passwordField name="passwordConfirm" required="" value="${userInstance?.passwordConfirm}"/>
</form:field>


<form:field bean="${userInstance}"
                   originalEntity="${AcademyUser}"
                   field="enabled">
    <components:checkbox name="enabled" value="${userInstance?.enabled}"/>
</form:field>





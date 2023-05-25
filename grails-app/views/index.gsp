<%@ page import="academy.chat.ChatMessageCommand" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <title>${message(code: 'home.label')}</title>
</head>
<body>

<div id="" style="display: flex; flex-direction:column;">

    <div>
        <messages:showFlash flash="${flash}"/>
    </div>

    <div style="background: #32a52a59;padding: 10px;width: 13%;margin: 10px;border-radius: 5px;">
%{--        <g:form controller="chat" action="saveClientMessage">--}%
%{--            <form:field bean="${chatMessage}"--}%
%{--                        originalEntity="${ChatMessageCommand}"--}%
%{--                        required="true"--}%
%{--                        placeholder="Enter your message"--}%
%{--                        field="message" />--}%
%{--            <buttons:submitSave/>--}%
%{--        </g:form>--}%
    </div>

    <div style="display: flex; justify-content: space-between; flex-direction: row-reverse; margin-top: 20px">
        Welcome to ${message(code: 'home.label')} ;)
    </div>

</div>

</body>
</html>

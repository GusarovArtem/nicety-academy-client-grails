<ul class="nav navbar-nav">
    <menu:branch title="Users" access="ROLE_ADMIN">
        <menu:leaf controller="academyAdmin"
                          title="Admin"
                          access="ROLE_ADMIN"/>
        <menu:leaf controller="academyClientManager"
                          title="Client Manager"
                          access="ROLE_ADMIN"/>
    </menu:branch>
</ul>




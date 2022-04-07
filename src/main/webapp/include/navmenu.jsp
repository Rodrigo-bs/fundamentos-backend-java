<%@ page pageEncoding="UTF-8" %>
<nav>
    <ul>
        <li><a href="agenda.jsp">Agenda</a></li>
        <li><a href="atendimento.jsp">Atendimento</a></li>
        <li><a href="pacientes.jsp">Pacientes</a></li>
        <li><a href="profissionais.jsp">Profissionais</a></li>
        <li><a href="convenios.jsp">Convênios</a></li>
        <li id="dropdown">
            <a href="javascript:void(0)">
                Configurações
                <i>&#9660;</i>
            </a>
            <div id="dropdown_conteudo">
                <a href="unidades.jsp">Unidades</a>
                <a href="especialidades.jsp">Especialidades</a>
                <a href="usuarios.jsp">Usuários</a>
            </div>
        </li>
    </ul>
</nav>
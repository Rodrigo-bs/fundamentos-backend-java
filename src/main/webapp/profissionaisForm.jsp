<%@ page pageEncoding="UTF-8" %>

<%
    String alertaMensagem = null;
    String alertaTipo = null;
%>

    <%@ include file="include/head.jsp" %>
        <%@ include file="include/header.jsp" %>
            <%@ include file="include/navmenu.jsp" %>

            <main>
                <% if (alertaMensagem != null) { %>
                    <jsp:include page="include/alerta.jsp">
                        <jsp:param name="alertaMensagem" value="<%=alertaMensagem%>" />
                        <jsp:param name="alertaTipo" value="<%=alertaTipo%>" />
                    </jsp:include>
                <% } %>

                <form action="#" method="post">
                    <div class="grid">
                        <input type="hidden" name="id">
                        <label for="nome">Nome</label>
                        <input type="text" name="nome" id="nome" required>
                        <label for="registroConselho">Registro</label>
                        <input type="text" name="registroConselho" id="registroConselho" required>
                        <label for="especialidade">Especialidade</label>
                        <select name="especialidade" id="especialidade" required>
                            <option value="">Selecione</option>
                            <option value="1">Oncologia</option>
                            <option value="2">Dermatologia</option>
                            <option value="3">Cardiologia</option>
                        </select>
                        <label for="unidade">Unidade</label>
                        <select name="unidade" id="unidade" required>
                            <option value="">Selecione</option>
                            <option value="1">Unidade A</option>
                            <option value="2">Unidade B</option>
                            <option value="3">Unidade C</option>
                        </select>
                        <label for="telefone">Telefone</label>
                        <input type="text" name="telefone" id="telefone">
                        <label for="email">E-mail</label>
                        <input type="email" name="email" id="email">
                    </div>
                    <input type="button" value="Cancelar" data-redirect="profissionais.jsp">
                    <input type="submit" value="Salvar" disabled>
                </form>

                <%@ include file="include/comandos.jsp" %>
            </main>
<%@ include file="include/footer.jsp" %>
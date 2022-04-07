<%@ page pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="br.ufac.sgcm.model.Profissional" %>

<jsp:useBean id="controller" class="br.ufac.sgcm.controller.ProfissionalController" scope="page" />

<%
    List<Profissional> registros = controller.getAll();
%>

    <%@ include file="include/head.jsp" %>
        <%@ include file="include/header.jsp" %>
            <%@ include file="include/navmenu.jsp" %>

            <main>
                <jsp:include page="include/alerta.jsp">
                    <jsp:param name="alertaMensagem" value="<%=alertaMensagem%>" />
                    <jsp:param name="alertaTipo" value="<%=alertaTipo%>" />
                </jsp:include>

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
                    <input type="button" value="Cancelar">
                    <input type="submit" value="Salvar" disabled>
                </form>

                <%@ include file="include/comandos.jsp" %>

                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Registro</th>
                            <th>Especialidade</th>
                            <th>Unidade</th>
                            <th>Telefone</th>
                            <th>E-mail</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Profissional item: registro) { %>
                            <tr>
                                <td class="fit"><%=item.getId()%></td>
                                <td><%=item.getNome()%></td>
                                <td><%=item.getRegistroConselho()%></td>
                                <td><%=item.getEspecialidade().getNome()%></td>
                                <td><%=item.getUnidade().getNome()%></td>
                                <td><%=item.getTelefone()%></td>
                                <td><%=item.getEmail()%></td>
                                <td>
                                    <a href="profissionaisForm.jsp?id=<%=item.getId()%>" class="botao">Editar</a>
                                    <a href="profissionais.jsp?excluir=<%=item.getId()%>" class="botao excluir">Excluir</a>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="8">Total de registros: <%=registros.size()%></td>
                        </tr>
                    </tfoot>
                </table>
            </main>
<%@ include file="include/footer.jsp" %>
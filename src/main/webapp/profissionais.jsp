<%@ page pageEncoding="UTF-8" %>
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
                        <tr>
                            <td class="fit">1</td>
                            <td>Beatriz Ventura</td>
                            <td>CRM/AC 123</td>
                            <td>Oncologia</td>
                            <td>Unidade A</td>
                            <td>(68) 34256-2345</td>
                            <td>beatri.ventura@gmail.com</td>
                            <td>
                                <a href="javascript:void(0)" class="botao">Editar</a>
                                <a href="javascript:void(0)" class="botao excluir">Excluir</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="fit">2</td>
                            <td>Brenda Portugal</td>
                            <td>CRM/AC 321</td>
                            <td>Dermatologia</td>
                            <td>Unidade B</td>
                            <td>(68) 32456-3456</td>
                            <td>brenda.portugal@gmail.com</td>
                            <td>
                                <a href="javascript:void(0)" class="botao">Editar</a>
                                <a href="javascript:void(0)" class="botao excluir">Excluir</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="fit">3</td>
                            <td>Gerson Benevides</td>
                            <td>CRM/AC 424</td>
                            <td>Cardiologia</td>
                            <td>Unidade C</td>
                            <td>(68) 94536-2345</td>
                            <td>gerson.benevides@gmail.com</td>
                            <td>
                                <a href="javascript:void(0)" class="botao">Editar</a>
                                <a href="javascript:void(0)" class="botao excluir">Excluir</a>
                            </td>
                        </tr>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="8">Total de registros: 3</td>
                        </tr>
                    </tfoot>
                </table>
            </main>
<%@ include file="include/footer.jsp" %>
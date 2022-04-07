<%@ page pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
    <%@ include file="include/head.jsp" %>
        <%@ include file="include/header.jsp" %>
            <%@ include file="include/navmenu.jsp" %>
            <main>
                <h1>Algo de errado não está certo!</h1>
                <pre>
                    <%=exception%>
                </pre>
            </main>
<%@ include file="include/footer.jsp" %>
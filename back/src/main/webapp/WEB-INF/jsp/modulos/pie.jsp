﻿<%@page import="es.caib.dir3caib.utils.CompileConstants"
%><%@page import="es.caib.dir3caib.persistence.utils.Versio"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" 
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" 
%>
<div class="container row-fluid">
    <div class="pull-left dir3caib-footer">DIR3CAIB - &copy; <fmt:message key="dir3caib.titulo"/> - <fmt:message key="dir3caib.version"/> <%=Versio.VERSIO + (CompileConstants.IS_CAIB?"-caib": "")%></div>
    <div class="pull-right govern-footer"> <img src="<c:url value="/img/govern-logo-neg.png"/>" width="129" height="30" alt="Govern de les Illes Balears" /></div>
</div>
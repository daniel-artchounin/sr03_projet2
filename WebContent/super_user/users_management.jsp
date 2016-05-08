<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Administrateur</title>
		<script src="<c:url value="/js/jquery-2.2.2.min.js"/>"></script>
		<link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
		<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
		<link href="<c:url value="/css/styles.css"/>" rel="stylesheet">
	</head>
	<body>
		<%@ include file="/header.jsp" %>   
		<jsp:include page="./menu.jsp" >
			<jsp:param name="usersManagement" value="usersManagement" />
		</jsp:include>
		<div class="container-fluid">
	    <c:if test="${ !empty sessionScope.superUser }">
	        <section>
				<c:if test="${! empty superUsers}">
					<div class="row">
					<div class="table-responsive"> 
					<table class="table table-hover table-bordered table-striped">
			        	<colgroup>
				            <col class="col-md-2">
				            <col class="col-md-2">
				            <col class="col-md-2">
				            <col class="col-md-1">
				            <col class="col-md-1">
				            <col class="col-md-2">
				            <col class="col-md-2">
        				</colgroup>
						<thead>
							<tr>
								<th>Nom</th>
								<th>Pr�nom</th>
								<th>E-mail</th>
								<th>T�l�phone</th>
								<th>Entreprise</th>
								<th>Date de cr�ation de compte</th>
								<th>Statut</th>
							</tr>
						</thead>
				        <c:forEach var="superUser" items="${ superUsers }">
				        	<tbody>
					        	<tr>
					        		<td><c:out value="${ superUser.surname }" /></td>
					        		<td><c:out value="${ superUser.name }" /></td>
					        		<td><c:out value="${ superUser.email }" /></td>
					        		<td><c:out value="${ superUser.phone }" /></td>
					        		<td><c:out value="${ superUser.company }" /></td>
					        		<td><c:out value="${ superUser.accountCreation }" /></td>
					        		<td><c:out value="${ superUser.accountStatus }" /></td>
					        	</tr>
				        	</tbody>
				        </c:forEach>						
			        </table>
			        </div>
			        </div>
		        </c:if>
		        
    			<c:if test="${! empty trainees}">
    				<div class="row">
					<div class="table-responsive"> 
					<table class="table table-hover table-bordered table-striped">
			        	<colgroup>
				            <col class="col-md-2">
				            <col class="col-md-2">
				            <col class="col-md-2">
				            <col class="col-md-1">
				            <col class="col-md-1">
				            <col class="col-md-2">
				            <col class="col-md-2">
        				</colgroup>
						<thead>
							<tr>
								<th>Nom</th>
								<th>Pr�nom</th>
								<th>E-mail</th>
								<th>T�l�phone</th>
								<th>Entreprise</th>
								<th>Date de cr�ation de compte</th>
								<th>Statut</th>
							</tr>
						</thead>
				        <c:forEach var="trainee" items="${ trainees }">
				        	<tbody>
					        	<tr>
					        		<td><c:out value="${ trainee.surname }" /></td>
					        		<td><c:out value="${ trainee.name }" /></td>
					        		<td><c:out value="${ trainee.email }" /></td>
					        		<td><c:out value="${ trainee.phone }" /></td>
					        		<td><c:out value="${ trainee.company }" /></td>
					        		<td><c:out value="${ trainee.accountCreation }" /></td>
					        		<td><c:out value="${ trainee.accountStatus }" /></td>
					        	</tr>
				        	</tbody>
				        </c:forEach>						
			        </table>
			        </div>
			        </div>
		        </c:if>
	    	</section>
	    </c:if>
	    </div>
	    <%@ include file="/footer.jsp" %>
	</body>
</html>
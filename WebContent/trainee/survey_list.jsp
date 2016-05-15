<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Liste des questionnaires</title>
		<script src="<c:url value="/js/jquery-2.2.2.min.js"/>"></script>
		<link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
		<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
		<link rel="stylesheet" type="text/css" href="<c:url value="/DataTables/datatables.min.css"/>"/>
		<script type="text/javascript" src="<c:url value="/DataTables/datatables.min.js"/>"></script>
		<script src="<c:url value="surveyList.js"/>"></script>
		<link href="<c:url value="/css/styles.css"/>" rel="stylesheet">
	</head>
	<body>
		<%@ include file="/header.jsp" %>   
		<jsp:include page="./menu.jsp" >
			<jsp:param name="surveyList" value="surveyList" />
		</jsp:include>
		
		<div class="container-fluid">
			<h3>Listes des questionnaires </h3>
			
			<c:if test="${ !empty sessionScope.trainee }">
				<section>
							<table class="table table-bordered" id="surveyList">
								<thead>
						            <tr>
						                <th>#</th>
						                <th>Th�me</th>
						                <th>Questionnaire</th>
						            </tr>
						        </thead>
						        <tbody>
						        <c:forEach var="topic" items="${ topics }" varStatus="status">
							        
						                <c:forEach var="questionnaire" items="${ topic.questionnaires }" varStatus = "statusQuestionnaire">
						                	<tr>
						                		<td>${ status.count + statusQuestionnaire.count - 1 }</td>
						                		<td>${ topic.name }</td>
						                		<td>${ questionnaire.name }</td>
						                	</tr>
						                </c:forEach>
							        
						        </c:forEach>
						        </tbody>	
							</table>
				
					
				
	    	</section>
			</c:if>
		</div>
		
	    <%@ include file="/footer.jsp" %>
	</body>
</html>
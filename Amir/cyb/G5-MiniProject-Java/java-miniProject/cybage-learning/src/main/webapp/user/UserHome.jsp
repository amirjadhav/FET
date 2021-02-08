<jsp:include page="user-header.jsp"></jsp:include>

<%@page import="com.cybage.model.Category"%>
<%@page import="java.util.List"%>
<body>
	<!-- To import list and Category Model -->



	<!--Inline CSS -->
	<style>
.card {
	width: 18rem;
	padding: 3%;
	padding-top: 5%;
	margin-top: 7%;
	margin-bottom: 5%;
	margin-left: 5%;
	margin-right: 5%;
}


.jumbotron {
	background-color: 60c7c1;
}
</style>

	<!-- Banner Jumbotron -->
	<div class="jumbotron">
		<h1 class="display-4">Cybage E-Learning</h1>
		<p class="lead">A learning system based on formalised teaching but
			with the help of electronic resources is known as E-learning. While
			teaching can be based in or out of the classrooms, the use of
			computers and the Internet forms the major component of E-learning.
			E-learning can also be termed as a network enabled transfer of skills
			and knowledge, and the delivery of education is made to a large
			number of recipients at the same or different times.</p>
		<hr class="my-4">
		<p>E-learning has proved to be the best means in the corporate
			sector, especially when training programs are conducted by MNCs for
			professionals across the globe and employees are able to acquire
			important skills while sitting in a board room, or by having
			seminars, which are conducted for employees of the same or the
			different organizations under one roof.</p>
		<p class="lead"></p>
	</div>



<div class="row gx-5 gy-5">
<div class="col-lg-6 col-sm-12">
	<%if((request.getAttribute("categories"))!=null) {
		List<Category> category = (List) request.getAttribute("categories");
		for (Category c : category) {
			
			out.print("<div class='card' >");
			out.print("<img class='card-img-top' src='" + c.getImageUrl() + "'>");
			out.print("<div class='card-body'>");
			out.print("<h3 class='card-title'>'" + c.getCategoryName() + "'</h3>'");
			
			out.print(
					"<a href='courses.jsp' class='btn btn-primary'>View Courses</a>");
			out.print("</div>");
			out.print("</div>");

		}
	}
	if((request.getAttribute("categories"))==null){
		out.print("<a class='btn btn primary' href='"+request.getContextPath()+"/UserController/list'>VIEW MAIN PAGE</a>");
	}
%>
</div>
</div>



	<!--To apply bootstrap on the html written above -->
	<link rel="stylesheet"
		href="webjars/bootstrap/4.5.3/css/bootstrap.min.css">
	<script src="webjars/bootstrap/4.5.3s/js/bootstrap.min.js"></script>

</body>

<jsp:include page="user-footer.jsp"></jsp:include>

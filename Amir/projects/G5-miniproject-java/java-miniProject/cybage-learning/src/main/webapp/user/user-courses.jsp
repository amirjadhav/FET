<jsp:include page="user-header.jsp"></jsp:include>

<%@page import="com.cybage.model.Category"%>
<%@page import="com.cybage.model.Course"%>
<%@page import="java.util.List"%>

<body>
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
</style>
	<%
		if ((request.getAttribute("completedList")) != null) {
			out.print("<hr>");
			out.print("<h1>Completed Courses</h1>");
			out.print("<hr>");
			out.print("<div class='contrainer-fluid'>");
			out.print("<div class='row text-center'>");
			List<Course> course = (List) request.getAttribute("completedList");
			for (Course c : course) {
				out.print("<div class='col-md-3  col-sm-3'>");
				out.print("<div class='card' >");
				out.print("<img class='card-img-top' src='" + c.getImageUrl() + "'>");
				out.print("<div class='card-body'>");
				out.print("<h3 class='card-title'>'" + c.getCourseName() + "'</h3>");
				out.print("<p class='card-text'>" + c.getCourseDescription() + "</p>");
				out.print("<div class='text-center'>");
				out.print("<a href='" + request.getContextPath() + "/UserController/get-certificate?id="
						+ c.getCourseId() + "' class='btn btn-warning '>Generate Certificate(LINK)</a>");
				out.print("</div>");
				out.print("</div>");
				out.print("</div>");
				out.print("</div>");

			}
			out.print("</div>");
			out.print("</div>");
		}
	%>
	<hr>
	<h1>Enrolled Courses</h1>
	<hr>
	<div class="contrainer-fluid">
		<div class="row">

			<%
				if ((request.getAttribute("enrolledList")) != null) {
					List<Course> course = (List) request.getAttribute("enrolledList");
					for (Course c : course) {
						out.print("<div class='col-md-3  col-sm-3'>");
						out.print("<div class='card' >");
						out.print("<img class='card-img-top' src='" + c.getImageUrl() + "'>");
						out.print("<div class='card-body'>");
						out.print("<h3 class='card-title'>'" + c.getCourseName() + "'</h3>");
						out.print("<p class='card-text'>" + c.getCourseDescription() + "</p>");
						out.print("<div class='text-center'>");
						out.print("<a href='" + request.getContextPath() + "/UserController/start-course?id="
								+ c.getCourseId() + "&amp;vid=0' class='btn btn-warning'>Continue to Course</a>");
						out.print("</div>");
						out.print("</div>");
						out.print("</div>");
						out.print("</div>");
					}
				}
			%>
		</div>
	</div>
	<hr>
	<h1>Other Courses</h1>
	<hr>

	<%
		if ((request.getAttribute("courseList")) != null) {
			List<Course> course = (List) request.getAttribute("courseList");
			String prime = request.getAttribute("isPrime").toString();
			for (Course c : course) {
				out.print("<div class='col-md-3  col-sm-3'>");
				out.print("<div class='card' >");
				out.print("<img class='card-img-top' src='" + c.getImageUrl() + "'>");
				out.print("<div class='card-body'>");
				out.print("<h3 class='card-title'>'" + c.getCourseName() + "'</h3>");
				out.print("<p class='card-text'>ABOUT COURSE:<br>" + c.getCourseDescription() + "</p>");
				if (prime == "true") {
					c.setCoursePrice(c.getCoursePrice() - (c.getCoursePrice() / 10));
					out.print("<p class='card-text'>COURSE PRICE: " + c.getCoursePrice() + "&#8377 10% OFF</p>");
				} else {
					out.print("<p class='card-text'>COURSE PRICE: " + c.getCoursePrice() + "&#8377</p>");
				}
				out.print("<div class='text-center'>");
				out.print("<a href='" + request.getContextPath() + "/UserController/enroll-course?id="
						+ c.getCourseId() + "&amp;price=" + c.getCoursePrice()
						+ "' class='btn btn-warning'>Start Courses</a>");
				out.print("</div>");
				out.print("</div>");
				out.print("</div>");
				out.print("</div>");
			}
		}
	%>
	</div>
	</div>

	<jsp:include page="../footer.jsp"></jsp:include>
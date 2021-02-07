<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<jsp:include page="header.jsp"></jsp:include>

<h1>Start course-page</h1>
<% Object currentVideo =session.getAttribute("video_count");
Object videoCount =session.getAttribute("video_count");

int currentVideo_int =Integer.parseInt(currentVideo.toString());
int videoCount_int =Integer.parseInt(videoCount.toString());

if(currentVideo == videoCount){
	System.out.println("Generate certificate");
}
%>
<%--  ${(videoCount > 0) ? "some text when true" : "some text when false"} --%>

<div class="container-fluid course-container">
	<div class="row">
		<div class="col-sm-8 title">Course Title</div>

		<div class="col-sm-4 p-bar">Progress bar</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-8 video">
			<div class="row">
				<div class="container-fluid">
					<video id="myVideo" class="center" webkit-playsinline="" width="90%" height="90%" controls>
						<source src="videos/1.mp4" type="video/mp4" />
						Your browser does not support HTML5 video.
					</video>
				</div>
				</div>
				<div class="row">
					<div class="container-fluid btn-control">
						<a href="#" class="btn btn-primary">Prev</a>
						<a href="<%=request.getContextPath()%>/UserController/start-course/<%=currentVideo_int++%>" class="btn btn-primary">Next</a>
						<%System.out.print("Hello"); %>
					</div>
				</div>
			</div>


			<div class="col-sm-4 description">desc</div>
		</div>
	</div>
</div>
 <%System.out.println("subcourses data:"+ session.getAttribute("subcourse_id"));%> 
<jsp:include page="footer.jsp"></jsp:include>

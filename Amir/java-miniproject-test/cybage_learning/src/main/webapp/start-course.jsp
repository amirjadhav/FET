<jsp:include page="header.jsp"></jsp:include>
<h1>Start course-page</h1>

<div class="container-fluid course-container">
	<div class="row">
		<div class="col-sm-8 title">title</div>

		<div class="col-sm-4 p-bar">p-bar</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-8 video">
				<div class="container center">
					<video id="myVideo" webkit-playsinline="" width="320" height="176" controls>

						<source src="videos/1.mp4" type="video/mp4" />

						Your browser does not support HTML5 video.
					</video>
				</div>
				<div class="row">
					<div class="container">buttons</div>
				</div>
			</div>


			<div class="col-sm-4 description">desc</div>
		</div>
	</div>
</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

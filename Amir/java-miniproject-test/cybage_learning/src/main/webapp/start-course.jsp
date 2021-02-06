<jsp:include page="header.jsp"></jsp:include>
<h1>Start course-page</h1>

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
						<button class="btn btn-primary">Prev</button>
						<button class="btn btn-primary">Next</button>
					</div>
				</div>
			</div>


			<div class="col-sm-4 description">desc</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

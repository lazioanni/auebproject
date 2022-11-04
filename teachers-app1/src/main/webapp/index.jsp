<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
	integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	integrity="sha256-IUOUHAPazai08QFs7W4MbzTlwEWFo7z/4zw8YmxEiko="
	crossorigin="anonymous">
<script src="./static/js/index.js"></script>
</head>
<body>
	<div class="container-fluid bg-secondary">


		<div class="container bg-secondary">

			<div class="row align-items-center m-4 p-3">
				<div class="col">
					<h1 class="bg-seconndary text-light">Προγράμματα e-Learning
						Οικονομικoύ Πανεπιστημιού Αθηνών</h1>
				</div>
			</div>


			<div class="container bg-primary rounded-pill m-4 p-3">


				<div class="row m-3">
					<h3 class="d-flex justify-content-center text-light col">
						<strong>Γνωρίστε τα Προγράμματα Μας</strong>
					</h3>
				</div>

				<div class="row justify-content-center">
					<div class="col-8">
						<div id="carouselCaptions" class="carousel slide"
							data-bs-ride="false">
							<div class="carousel-indicators">
								<button type="button" data-bs-target="#carouselCaptions"
									data-bs-slide-to="0" class="active" aria-current="true"
									aria-label="Slide 1"></button>
								<button type="button" data-bs-target="#carouselCaptions"
									data-bs-slide-to="1" aria-label="Slide 2"></button>
								<button type="button" data-bs-target="#carouselCaptions"
									data-bs-slide-to="2" aria-label="Slide 3"></button>
								<button type="button" data-bs-target="#carouselCaptions"
									data-bs-slide-to="3" aria-label="Slide 4"></button>
								<button type="button" data-bs-target="#carouselCaptions"
									data-bs-slide-to="4" aria-label="Slide 5"></button>
							</div>
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img src="./static/img/analysis-of-clinical-trials-data.jpg"
										class="w-100 h-auto" alt="...">
									<div class="carousel-caption text-dark">
										<h5>
											<strong>Ανάλυση Δεδομένων Κλινικών Δοκιμών μέσω SPSS</strong>
										</h5>
									</div>
								</div>
								<div class="carousel-item">
									<img src="./static/img/matlab.jpg" class="w-100 h-auto"
										alt="...">
									<div class="carousel-caption text-dark">
										<h5>
											<strong>Αρχές Προγραμματισμού με MATLAB & OCTAVE</strong>
										</h5>
									</div>
								</div>
								<div class="carousel-item">
									<img src="./static/img/PI_javafull.jpg" class="w-100 h-auto"
										alt="...">
									<div class="carousel-caption text-light">
										<h5>
											<strong>Java Full Stuck Web Programming με Java
												Enteprise Edition, Hibernate και Spring</strong>
										</h5>
									</div>
								</div>
								<div class="carousel-item">
									<img src="./static/img/data-analysisR.jpg" class="w-100 h-auto"
										alt="...">
									<div class="carousel-caption text-danger">
										<h5>
											<strong>Ανάλυση Δεδομένων με τη χρήση της R </strong>
										</h5>
									</div>
								</div>
								<div class="carousel-item">
									<img src="./static/img/PI_influencer.jpg" class="w-100 h-auto"
										alt="...">
									<div class="carousel-caption text-light">
										<h5>
											<strong>Influencer Marketing</strong>
										</h5>
									</div>
								</div>
								<button class="carousel-control-prev" type="button"
									data-bs-target="#carouselCaptions" data-bs-slide="prev">
									<span class="carousel-control-prev-icon" aria-hidden="true"></span>
									<span class="visually-hidden">Previous</span>
								</button>
								<button class="carousel-control-next" type="button"
									data-bs-target="#carouselCaptions" data-bs-slide="next">
									<span class="carousel-control-next-icon" aria-hidden="true"></span>
									<span class="visually-hidden">Next</span>
								</button>
							</div>
						</div>
					</div>

					<div class="row rounded-pill justify-content-center m-3">
						<div
							class="d-flex col-4 justify-content-center bg-secondary rounded-pill">
							<button type="button" class="btn bg-secondary text-light"
								data-bs-toggle="modal" data-bs-target="#exampleModal">
								Σύνδεση/Εγγραφή</button>
						</div>
					</div>



				</div>
			</div>

			<div class="container bg-primary rounded-pill m-4 p-3">

				<div class="row rounded-pill justify-content-center m-3">
					<h3 class="col-5 text-light">
						<strong>Παρουσίαση Προγραμμάτων</strong>
					</h3>
				</div>

				<div class="row justify-content-center m-3">
					<div class="col-6">
						<iframe width="600" height="300"
							src="https://www.youtube.com/embed/wvuESxm9jtw"
							title="YouTube video player" frameborder="0"
							allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
							allowfullscreen></iframe>
					</div>
				</div>

				<div class="row rounded-pill justify-content-center m-3">
					<div
						class="d-flex col-4 justify-content-center bg-secondary rounded-pill">
						<button type="button" class="btn bg-secondary text-light"
							data-bs-toggle="modal" data-bs-target="#adminModal">
							Σύνδεση ώς Διαχειριστής</button>
					</div>
				</div>
			</div>
		</div>
	</div>



	<div class="modal" id="adminModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header row bg-secondary">
					<h5 class="modal-title bg-primary text-light rounded-pill col-8">Σύνδεση
						ως Διαχειριστής</h5>
					<button type="button col-2 text-danger" class="btn-close"
						data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body bg-secondary">
					<form>
						<div class="m-3 d-flex justify-content-center">
							<div class="col-1 p-0 m-2">
								<i class="fa-regular fa-envelope fa-2xl"></i>
							</div>
							<div class="col-7">
								<input type="email" class="form-control" id="adminEmail"
									placeholder="E-mail">
							</div>
						</div>
						<div class="m-3 d-flex justify-content-center">
							<div class="col-1 p-0 m-2">
								<i class="fa-solid fa-lock fa-2xl" class="col-2"></i>
							</div>
							<div class="col-7">
								<input type="password" class="form-control" id="adminPassword"
									placeholder="Password">
							</div>
						</div>
						<div class="text-center">
							<button type="button" id="loginAdmin" class="btn btn-primary col-9 mb-5">Σύνδεση</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>




	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Σύνδεση/Εγγραφή</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<ul class="nav nav-pills">
						<li class="nav-item"><a class="nav-link active"
							data-bs-toggle="pill" href="#login">Σύνδεση</a></li>
						<li class="nav-item"><a class="nav-link"
							data-bs-toggle="pill" href="#signup">Εγγραφή</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane container active" id="login">
							<form action="${pageContext.request.contextPath}/login" method="POST">
								<div class="row text-center mt-5">
									<h5>Συνδεθείται στο A.U.E.B. E-Learning</h5>
								</div>
								<div class=" d-flex justify-content-center mb-5">
									Δεν έχετε λογαριασμό;
								</div>
								<div class="mb-3 d-flex justify-content-center">
									<div class="col-1 p-0 m-2">
										<i class="fa-regular fa-envelope fa-2xl"></i>
									</div>
									<div class="col-7">
										<input type="email" class="form-control"
											name="loginEmail" aria-describedby="emailHelp"
											placeholder="E-mail">
									</div>
								</div>
								<div class="mb-3 d-flex justify-content-center">
									<div class="col-1 p-0 m-2">
										<i class="fa-solid fa-lock fa-2xl" class="col-2"></i>
									</div>

									<div class="col-7">
										<input type="password" class="form-control"
											 name="loginPassword" placeholder="Password">
									</div>
								</div>
								<div class="text-center">
									<button type="submit" class="btn btn-primary col-9 mb-5">Σύνδεση</button>
								</div>
							</form>
						</div>

						<div class="tab-pane container fade" id="signup">
							<div class="row text-center m-5">
								<h5>Εγγραφή στο A.U.E.B. E-Learning</h5>
							</div>
							<nav>
								<div class="nav nav-tabs" id="nav-tab" role="tablist">
									<button class="nav-link active" id="nav-teacher-tab"
										data-bs-toggle="tab" data-bs-target="#nav-teacher"
										type="button" role="tab" aria-selected="true">Teacher</button>
									<button class="nav-link" id="nav-student-tab"
										data-bs-toggle="tab" data-bs-target="#nav-student"
										type="button" role="tab" aria-selected="false">Student</button>
								</div>
							</nav>
							<div class="tab-content" id="nav-tabContent">
								<div class="tab-pane fade show active" id="nav-teacher"
									role="tabpanel" aria-labelledby="nav-teacher-tab">
									<form method="POST" action="${pageContext.request.contextPath}/teacherInsertForm">
										<div class="row justify-content-center m-3">
											<div class="col">
												<label for="teachername" class="form-label">Όνομα</label> <input
													type="text" class="form-control" name="teachername" required>
											</div>
										</div>
										<div class="row justify-content-center m-3">
											<div class="col">
												<label for="teacherlastname" class="form-label">Επώνυμο</label>
												<input type="text" class="form-control" name="teacherlastname"
													required>
											</div>
										</div>
										<div class="row justify-content-center m-3">
											<div class="col">
												<label for="teachersubject" class="form-label">Αντικείμενο
													Σπουδών</label> <input type="text" class="form-control"
													name="teachersubject" required>
											</div>
										</div>
										<div class="row justify-content-center m-3">
											<div class="col">
												<label for="select" class="form-label">Πανεπιστημιακή
													Βαθμίδα</label> <select name="teacherRank" class="form-select"
													required>
													<option selected>Lecturer</option>
													<option>Επίκουρος Καθηγητής</option>
													<option>Αναπληρωτής Καθηγητής</option>
													<option>Καθηγητής</option>
												</select>
											</div>
										</div>
										<div class="row justify-content-center m-3">
											<div class="col">
												<label for="teacheremail" class="form-label">E-mail</label>
												<input type="text" class="form-control" name="teacheremail"
													required>
											</div>
										</div>
										<div class="row justify-content-center m-3">
											<div class="col">
												<label for="teacherpassword" class="form-label">Password</label>
												<input type="password" class="form-control"
													name="teacherpassword" placeholder="Password">
											</div>
										</div>
										<div class="row justify-content-center m-3">
											<div class="col">
												<label for="teacherconfirmpassword" class="form-label">Confirm
													Password</label> <input type="password" class="form-control"
													name="teacherconfirmpassword" placeholder="Confirm Password">
											</div>
										</div>
										<div class="row m-3 p-3 justify-content-center">
											<button type="submit" class="btn btn-primary  mb-5"
												>Εγγραφή</button>
										</div>
									</form>

								</div>



								<div class="tab-pane fade" id="nav-student" role="tabpanel"
									aria-labelledby="nav-student-tab">
									<form action="${pageContext.request.contextPath}/studentSignUp" method="POST">
										<div class="row justify-content-center m-3">
											<div class="col">
												<label for="studentname" class="form-label">Όνομα</label> <input
													type="text" class="form-control" name="studentname" required>
											</div>
										</div>
										<div class="row justify-content-center m-3">
											<div class="col">
												<label for="studentlastname" class="form-label">Επώνυμο</label>
												<input type="text" class="form-control" name="studentlastname"
													required>
											</div>
										</div>
										<div class="row justify-content-center m-3">
											<div class="col">
												<label for="studentRank" class="form-label">Επίπεδο
													Σπουδών</label> <select name="studentRank" class="form-select" required>
													<option selected>Προπτυχιακός Φοιτητής</option>
													<option>Μεταπτυχιακός Φοιτητής</option>
													<option>Διδακτορικός Φοιτητής</option>
													<option>ΜεταΔιδακτορικός Φοιτητής</option>
												</select>
											</div>
										</div>
										<div class="row justify-content-center m-3">
											<div class="col">
												<label for="university" class="form-label">Πανεπιστημιακή
													Μονάδα</label> <select name="university" class="form-select" required>
													<option selected>Οικονομικό Πανεπιστήμιο Αθηνών</option>
													<option>Εθνικό Μετσόβιο Πολυτεχνείο</option>
													<option>Εθνικό και Καποδιστριακό Πανεπιστήμιο
														Αθηνών</option>
													<option>Πανεπιστήμιο Πειραιά</option>
													<option>Αριστοτέλειο Πανεπιστήμιο Θεσσαλονίκης</option>
													<option>Πανεπιστήμιο Μακεδονίας</option>
												</select>
											</div>
										</div>
										<div class="row justify-content-center m-3">
											<div class="col">
												<label for="studentemail" class="form-label">E-mail</label>
												<input type="text" class="form-control" name="studentemail"
													required>
											</div>
										</div>
										<div class="row justify-content-center m-3">
											<div class="col">
												<label for="studentpassword" class="form-label">Password</label>
												<input type="password" class="form-control"
													name="studentpassword" placeholder="Password">
											</div>
										</div>
										<div class="row justify-content-center m-3">
											<div class="col">
												<label for="studentconfirmpassword" class="form-label">Confirm
													Password</label> <input type="password" class="form-control"
													id="studentconfirmpassword" placeholder="Confirm Password">
											</div>
										</div>
										<div class="row m-3 p-3 justify-content-center">
											<button type="submit" class="btn btn-primary  mb-5"
												>Εγγραφή</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>





	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha256-xLI5SjD6DkojxrMIVBNT4ghypv12Xtj7cOa0AgKd6wA="
		crossorigin="anonymous"></script>
</body>
</html>
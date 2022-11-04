<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	integrity="sha256-IUOUHAPazai08QFs7W4MbzTlwEWFo7z/4zw8YmxEiko="
	crossorigin="anonymous">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
	integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="../static/js/dashboard.js"></script>
<title>Document</title>
</head>
<body>
	<div class="container-fluid bg-white p-0 m-0">
		<div class="container-fluid row bg-secondary align-items-center m-0">
			<div class="d-flex col-2 justify-content-center bg-secondary">
				<div class="nav flex-column my-5 mx-auto nav-pills container"
					id="v-pills-tab" role="tablist" aria-orientation="vertical">
					<button class="nav-link active text-white" id="v-pills-profile-tab"
						data-bs-toggle="pill" data-bs-target="#v-pills-profile"
						type="button" role="tab" aria-controls="v-pills-profile"
						aria-selected="false">Profile</button>
					<button class="nav-link text-white" id="teacherstab" name="teacherstab"
						data-bs-toggle="pill" href="#teachers" type="button" role="tab"
						aria-selected="false" onclick="fetchTeachersFromJSON()">Teachers</button>
					<button class="nav-link text-white" id="studentstab"
						data-bs-toggle="pill" href="#students" type="button" role="tab"
						aria-controls="v-pills-messages" aria-selected="false" onclick="fetchStudentsFromJSON()">Students</button>
					<button class="nav-link text-white" id="coursestab"
						data-bs-toggle="pill" href="#courses" type="button" role="tab"
						aria-controls="v-pills-settings" aria-selected="false" onclick="fetchCoursesFromJSON()">Courses</button>
				</div>
			</div>
			<div
				class="d-flex col-10 justify-content-center bg-secondary m-0 p-0">
				<div class="tab-content bg-secondary" id="v-pills-tabContent">
					<div class="tab-pane fade show active" id="v-pills-profile"
						role="tabpanel" aria-labelledby="v-pills-profile-tab" tabindex="0">
						<div class="container">
							<h1 class="text-white text-center p-3">My Profile</h1>
							<form class="m-1 rounded-circle p-5 bg-primary" id="profileForm">
								<div class="mb-3">
									<label for="id" class="form-label text-white">ID</label> <input
										type="text" class="form-control bg-primary text-dark"
										id="idprofile">
								</div>
								<div class="mb-3">
									<label for="email" class="form-label text-white">Email
										address</label> <input type="email"
										class="form-control  bg-primary text-dark" id="emailprofile"
										aria-describedby="emailHelp" disabled>
								</div>
								<div class="mb-3">
									<label for="name" class="form-label text-white">Name</label> <input
										type="text" class="form-control bg-primary text-dark"
										id="nameprofile" disabled>
								</div>
								<div class="mb-3">
									<label for="lastname" class="form-label text-white">Lastname</label>
									<input type="text" class="form-control  bg-primary text-dark"
										id="lastnameprofile" disabled>
								</div>
								<div class="mb-3">
									<label for="role" class="form-label text-white">Role</label> <input
										type="text" class="form-control  bg-primary text-dark"
										id="roleprofile" disabled>
								</div>
							</form>
						</div>
					</div>
					<div class="tab-pane fade" id="teachers" role="tabpanel"
						aria-labelledby="teacherstab" tabindex="1">
						<div class="container align-items-center row m-5">
							<h1
								class="text-white col text-center rounded-pill p-3 bg-primary">Teachers</h1>
						</div>
						<div class="row align-items-center">
							<h3 class="text-white col-4 align-text-end">Current Teachers
							</h3>
							<button type="button"
								class="btn btn-primary col-1 align-text-start"
								data-bs-toggle="modal" data-bs-target="#teacherModal">
								<i class="fa-solid fa-plus"></i>
							</button>
						</div>
						<div class="row align-items-center">
							<table class="table col-10" id="userTable">
								<thead>
									<tr>
										<th scope="col">Id</th>
										<th scope="col">Email Id</th>
										<th scope="col">Όνομα</th>
										<th scope="col">Επώνυμο</th>
										<th scope="col">Αντικείμενο</th>
										<th scope="col">Πανεπιστημιακή Βαθμίδα</th>
										<th scope="col">Eνημέρωση</th>
										<th scope="col">Διαγραφή</th>
									</tr>
								</thead>
								<tbody id="tbody">

								</tbody>
							</table>
						</div>
					</div>
					<div class="tab-pane fade" id="students" role="tabpanel"
						aria-labelledby="studentstab" tabindex="2">
						<div class="container d-flex row m-5">
							<h1 class="text-white text-center rounded-pill p-3 bg-primary">Students</h1>
						</div>
						<div class="row align-items-center">
							<h3 class="text-white col-4 align-text-end">Current Students
							</h3>
							<button type="button"
								class="btn btn-primary col-1 align-text-start"
								data-bs-toggle="modal" data-bs-target="#studentModal">
								<i class="fa-solid fa-plus"></i>
							</button>
						</div>
						<div class="row align-items-center">
							<table class="table" id="usersTable">
								<thead>
									<th scope="col">Id</th>
									<th scope="col">Email Id</th>
									<th scope="col">Όνομα</th>
									<th scope="col">Επώνυμο</th>
									<th scope="col">Επίπεδο Σπουδών</th>
									<th scope="col">Πανεπιστημιακή Μονάδα</th>
									<th scope="col">Eνημέρωση</th>
									<th scope="col">Διαγραφή</th>
								</thead>
								<tbody id="tbody">
								</tbody>
							</table>
						</div>
					</div>
					<div class="tab-pane fade" id="courses" role="tabpanel"
						aria-labelledby="coursestab" tabindex="3">
						<div class="container d-flex align-items-center">
							<h1 class="text-white text-center rounded-pill p-3 bg-primary">Courses</h1>
						</div>
						<div class="row align-items-center">
							<h3 class="text-white col align-text-start">Current Courses</h3>
							<button type="button"
								class="btn btn-primary col align-text-center"
								data-bs-toggle="modal" data-bs-target="#courseModal">
								<i class="fa-solid fa-plus"></i>
							</button>
						</div>
						<div class="row align-items-center">
							<table class="table" id="cTable">
								<thead>
									<th scope="col">Id</th>
									<th scope="col">Τίτλος</th>
									<th scope="col">Περιγραφή</th>
									<th scope="col">Teacher ID</th>
								</thead>
								<tbody id="tbody">

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal" id="courseModal" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5 text-align-center" id="insertTeacher">Εισαγωγή
						Μαθήματος</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form method="POST" action="/teachers-app1/courseInsertForm">
						<div class="mb-3">
							<label for="courseTitle" class="form-label">Τίτλος</label> <input
								type="text" class="form-control" name="courseTitle" required>
						</div>
						<div class="mb-3">
							<label for="courseDescription" class="form-label">Περιγραφή</label>
							<input type="text" class="form-control" name="courseDescription"
								required>
						</div>
						<div class="mb-3">
							<label for="courseTeacherId" class="form-label">Teacher ID</label>
							<input type="text" class="form-control" name="courseTeacherId"
								required>
						</div>
						<div class="row mx-auto">
							<button type="submit" class="btn btn-primary" id="courseInsert">Εισαγωγή</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal" id="courseUpdateModal" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5 text-align-center">Ενημέρωση
						Μαθήματος</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form name="updateCourse">
						<div class="mb-3">
							<label for="courseId" class="form-label">ID</label> <input
								type="text" class="form-control" id="courseIdUpdate" required>
						</div>
						<div class="mb-3">
							<label for="courseTitle" class="form-label">Τίτλος</label> <input
								type="text" class="form-control" id="courseTitleUpdate" required>
						</div>
						<div class="mb-3">
							<label for="courseDescription" class="form-label">Περιγραφή</label>
							<input type="text" class="form-control" id="courseDescriptionUpdate"
								required>
						</div>
						<div class="mb-3">
							<label for="courseTeacherId" class="form-label">Teacher ID</label>
							<input type="text" class="form-control" id="courseTeacherIdUpdate"
								required>
						</div>
						<div class="row mx-auto">
							<button type="button" class="btn btn-primary" onclick="updateCourses()">Ενημέρωση</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal" id="studentModal" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5 text-align-center" id="insertTeacher">Εισαγωγή
						Μαθητή</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="/teachers-app1/studentInsert" method="POST">
						<div class="mb-3">
							<label for="studentname" class="form-label">Όνομα</label> <input
								type="text" class="form-control" name="studentname" required>
						</div>
						<div class="mb-3">
							<label for="studentlastname" class="form-label">Επώνυμο</label> <input
								type="text" class="form-control" name="studentlastname" required>
						</div>
						<div class="mb-3">
							<label for="studentRank" class="form-label">Επίπεδο Σπουδών</label> <select
								name="studentRank" class="form-select" required>
								<option selected>Προπτυχιακός Φοιτητής</option>
								<option>Μεταπτυχιακός Φοιτητής</option>
								<option>Διδακτορικός Φοιτητής</option>
								<option>ΜεταΔιδακτορικός Φοιτητής</option>
							</select>
						</div>
						<div class="mb-3">
							<label for="studentemail" class="form-label">Email address</label> <input
								type="email" class="form-control" name="studentemail" required>
						</div>
						<div class="mb-3">
							<label for="university" class="form-label">Πανεπιστημιακή
								Μονάδα</label> <select name="university" class="form-select" required>
								<option selected>Οικονομικό Πανεπιστήμιο Αθηνών</option>
								<option>Εθνικό Μετσόβιο Πολυτεχνείο</option>
								<option>Εθνικό και Καποδιστριακό Πανεπιστήμιο Αθηνών</option>
								<option>Πανεπιστήμιο Πειραιά</option>
								<option>Αριστοτέλειο Πανεπιστήμιο Θεσσαλονίκης</option>
								<option>Πανεπιστήμιο Μακεδονίας</option>
							</select>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="studentpassword" class="form-label">Password</label>
								<input type="password" class="form-control" name="studentpassword"
									placeholder="Password">
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="studentconfirmpassword" class="form-label">Confirm
									Password</label> <input type="password" class="form-control"
									id="studentconfirmpassword" placeholder="Confirm Password">
							</div>
						</div>
						<div class="row mx-auto">
							<button type="submit" class="btn btn-primary" >Εισαγωγή</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>





	<div class="modal" id="studentModalUpdate" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5 text-align-center" id="insertTeacher">Ενημέρωση
						Μαθητή</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form>
						<div class="mb-3">
							<label for="studentIdUpdate" class="form-label">ID</label> <input
								type="text" class="form-control" id="studentIdUpdate" required>
						</div>
						<div class="mb-3">
							<label for="studentNameUpdate" class="form-label">Όνομα</label> <input
								type="text" class="form-control" id="studentNameUpdate" required>
						</div>
						<div class="mb-3">
							<label for="studentLastnameUpdate" class="form-label">Επώνυμο</label> <input
								type="text" class="form-control" id="studentLastnameUpdate" required>
						</div>
						<div class="mb-3">
							<label for="studentRankUpdate" class="form-label">Επίπεδο Σπουδών</label> <select
								id="studentRankUpdate" class="form-select" required>
								<option selected>Προπτυχιακός Φοιτητής</option>
								<option>Μεταπτυχιακός Φοιτητής</option>
								<option>Διδακτορικός Φοιτητής</option>
								<option>ΜεταΔιδακτορικός Φοιτητής</option>
							</select>
						</div>
						<div class="mb-3">
							<label for="studentEmailUpdate" class="form-label">Email address</label> <input
								type="email" class="form-control" id="studentEmailUpdate" required>
						</div>
						<div class="mb-3">
							<label for="universityUpdate" class="form-label">Πανεπιστημιακή
								Μονάδα</label> <select id="universityUpdate" class="form-select" required>
								<option selected>Οικονομικό Πανεπιστήμιο Αθηνών</option>
								<option>Εθνικό Μετσόβιο Πολυτεχνείο</option>
								<option>Εθνικό και Καποδιστριακό Πανεπιστήμιο Αθηνών</option>
								<option>Πανεπιστήμιο Πειραιά</option>
								<option>Αριστοτέλειο Πανεπιστήμιο Θεσσαλονίκης</option>
								<option>Πανεπιστήμιο Μακεδονίας</option>
							</select>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="studentpassword" class="form-label">Password</label>
								<input type="password" class="form-control" id="studentPasswordUpdate"
									placeholder="Password">
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="studentconfirmpassword" class="form-label">Confirm
									Password</label> <input type="password" class="form-control"
									id="studentconfirmpassword" placeholder="Confirm Password">
							</div>
						</div>
						<div class="row mx-auto">
							<button type="button" class="btn btn-primary" onclick="updateStudents()">Ενημέρωση</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<div class="modal" id="teacherModal" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5 text-align-center">Εισαγωγή Καθηγητή</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="/teachers-app1/teacherInsert" method="POST">
						<div class="mb-3">
							<label for="teachername" class="form-label">Όνομα</label> <input
								type="text" class="form-control" name="teachername" required>
						</div>
						<div class="mb-3">
							<label for="teacherlastname" class="form-label">Επώνυμο</label> <input
								type="text" class="form-control" name="teacherlastname" required>
						</div>
						<div class="mb-3">
							<label for="teachersubject" class="form-label">Αντικείμενο
								Σπουδών</label> <input type="text" class="form-control"
								name="teachersubject" required>
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">Email address</label> <input
								type="email" class="form-control" name="teacheremail" required>
						</div>
						<div class="mb-3">
							<label for="teacherRank" class="form-label">Πανεπιστημιακή
								Βαθμίδα</label> <select name="teacherRank" class="form-select" required>
								<option selected>Λέκτορας</option>
								<option>Επίκουρος Καθηγητής</option>
								<option>Αναπληρωτής Καθηγητής</option>
								<option>Καθηγητής</option>
							</select>
						</div>
						<div class="mb-3">
							<div class="col">
								<label for="teacherpassword" class="form-label">Password</label>
								<input type="password" class="form-control" name="teacherpassword"
									placeholder="Password">
							</div>
						</div>
						<div class="mb-3">
							<div class="col">
								<label for="teacherconfirmpassword" class="form-label">Confirm
									Password</label> <input type="password" class="form-control"
									name="teacherConfirmPassword" placeholder="Confirm Password">
							</div>
						</div>
						<div class="row mx-auto">
							<button type="submit" class="btn btn-primary">Εισαγωγή</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal" id="teacherModalUpdate" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5 text-align-center">Ενημέρωση Καθηγητή</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form>
						<div class="mb-3">
							<label for="teacherIdUpdate" class="form-label">ID</label> <input
								type="text" class="form-control" id="teacherIdUpdate" required>
						</div>
						<div class="mb-3">
							<label for="teacherNameUpdate" class="form-label">Όνομα</label> <input
								type="text" class="form-control" id="teacherNameUpdate" required>
						</div>
						<div class="mb-3">
							<label for="teacherLastnameUpdate" class="form-label">Επώνυμο</label> <input
								type="text" class="form-control" id="teacherLastnameUpdate" required>
						</div>
						<div class="mb-3">
							<label for="teacherSubjectUpdate" class="form-label">Αντικείμενο
								Σπουδών</label> <input type="text" class="form-control"
								id="teacherSubjectUpdate" required>
						</div>
						<div class="mb-3">
							<label for="teacherEmailUpdate" class="form-label">Email address</label> <input
								type="email" class="form-control" id="teacherEmailUpdate" required>
						</div>
						<div class="mb-3">
							<label for="teacherRankUpdate" class="form-label">Πανεπιστημιακή
								Βαθμίδα</label> <select id="teacherRankUpdate" class="form-select" required>
								<option selected>Λέκτορας</option>
								<option>Επίκουρος Καθηγητής</option>
								<option>Αναπληρωτής Καθηγητής</option>
								<option>Καθηγητής</option>
							</select>
						</div>
						<div class="mb-3">
							<div class="col">
								<label for="teacherPasswordUpdate" class="form-label">Password</label>
								<input type="password" class="form-control" id="teacherPasswordUpdate"
									placeholder="Password">
							</div>
						</div>
						<div class="mb-3">
							<div class="col">
								<label for="teacherconfirmpassword" class="form-label">Confirm
									Password</label> <input type="password" class="form-control"
									id="teacherConfirmPassword" placeholder="Confirm Password">
							</div>
						</div>
						<div class="row mx-auto">
							<button type="button" class="btn btn-primary" onclick="updateTeachers()">Ενημέρωση</button>
						</div>
					</form>
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
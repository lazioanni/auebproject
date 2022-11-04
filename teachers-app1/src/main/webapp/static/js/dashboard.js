    $(document).ready(function(){
        $('#cTable tbody').on('click', '.btnDelete', function () {
            let btnValue = $(this);
            let id = btnValue.val();

            let ajaxRequest = new XMLHttpRequest();

            ajaxRequest.open("GET",'/teachers-app1/deleteCourse'+ '?' + $.param({"id": id}),true);
            ajaxRequest.send();

            ajaxRequest.onreadystatechange = function(){
                if(ajaxRequest.readyState === 4){
                    if(ajaxRequest.status === 200){
                        const data = JSON.parse(ajaxRequest.responseText);
                        createCbody(data);
                    }else{
                        console.log('Error');
                    }
                }
            }
        });

        $('#cTable tbody').on('click', '.btnUpdate', function () {

            $('#courseUpdateModal').modal('show'); 
        });

        $('#userTable tbody').on('click', '.btnUpdate', function () {

            $('#teacherModalUpdate').modal('show'); 
        });

        $('#usersTable tbody').on('click', '.btnUpdate', function () {

            $('#studentModalUpdate').modal('show'); 
        });

       
        $('#usersTable tbody').on('click', '.btnDelete', function () {
            let btnValue = $(this);
            let id = btnValue.val();

            let ajaxRequest = new XMLHttpRequest();

            ajaxRequest.open("GET",'/teachers-app1/deleteStudent'+ '?' + $.param({"id": id}),true);
            ajaxRequest.send();

            ajaxRequest.onreadystatechange = function(){
                if(ajaxRequest.readyState === 4){
                    if(ajaxRequest.status === 200){
                        const data = JSON.parse(ajaxRequest.responseText);
                        createSbody(data);
                    }else{
                        console.log('Error');
                    }
                }
            }
        });

        $('#userTable tbody').on('click', '.btnDelete', function () {
            let btnValue = $(this);
            let id = btnValue.val();

            let ajaxRequest = new XMLHttpRequest();

            ajaxRequest.open("GET",'/teachers-app1/deleteTeacher'+ '?' + $.param({"id": id}),true);
            ajaxRequest.send();

            ajaxRequest.onreadystatechange = function(){
                if(ajaxRequest.readyState === 4){
                    if(ajaxRequest.status === 200){
                        const data = JSON.parse(ajaxRequest.responseText);
                        createTbody(data);
                    }else{
                        console.log('Error');
                    }
                }
            }
        });
    });

    function updateCourses(){
        
       
        $(document).ready(function(){
            var id,title,description,teacherId;
            id = $(this).find("#courseIdUpdate").val();
            title = $(this).find("#courseTitleUpdate").val();
            description = $(this).find("#courseDescriptionUpdate").val();
            teacherId = $(this).find("#courseTeacherIdUpdate").val();

            $.ajax({
                url: "/teachers-app1/updateCourse",
                data: { 
                    "id": id, 
                    "title": title, 
                    "description": description,
                    "teacherId":teacherId
                },
                type: "POST",
                success: function(response) {
                    createCbody(response);
                },
                error: function(xhr) {
                    console.log('Error');
                }
            });
            $('#courseUpdateModal').modal('hide');

        })
    }

    function updateStudents(){
         
        $(document).ready(function(){
            var id,name,lastname,rank,email,university,password;
            id = $(this).find("#studentIdUpdate").val();
            name = $(this).find("#studentNameUpdate").val();
            lastname = $(this).find("#studentLastnameUpdate").val();
            rank = $(this).find("#studentRankUpdate").val();
            email = $(this).find("#studentEmailUpdate").val();
            university = $(this).find("#universityUpdate").val();
            password = $(this).find("#studentPasswordUpdate").val();

            $.ajax({
                url: "/teachers-app1/updateStudent",
                data: { 
                    "id": id, 
                    "name": name, 
                    "lastname": lastname,
                    "rank":rank,
                    "email":email,
                    "university":university,
                    "password":password
                },
                type: "POST",
                success: function(response) {
                    createSbody(response);
                },
                error: function(xhr) {
                    console.log('Error');
                }
            });
            $('#studentModalUpdate').modal('hide');

        })
    }

    function updateTeachers(){
         
        $(document).ready(function(){
            var id,name,lastname,rank,email,subject,password;
            id = $(this).find("#teacherIdUpdate").val();
            name = $(this).find("#teacherNameUpdate").val();
            lastname = $(this).find("#teacherLastnameUpdate").val();
            rank = $(this).find("#teacherRankUpdate").val();
            email = $(this).find("#teacherEmailUpdate").val();
            subject = $(this).find("#teacherSubjectUpdate").val();
            password = $(this).find("#teacherPasswordUpdate").val();

            $.ajax({
                url: "/teachers-app1/updateTeacher",
                data: { 
                    "id": id, 
                    "name": name, 
                    "lastname": lastname,
                    "rank":rank,
                    "email":email,
                    "subject":subject,
                    "password":password
                },
                type: "POST",
                success: function(response) {
                    createTbody(response);
                },
                error: function(xhr) {
                    console.log('Error');
                }
            });
            $('#teacherModalUpdate').modal('hide');

        })
    }


  
    function fetchTeachersFromJSON(){
            let ajaxRequest = new XMLHttpRequest();

            ajaxRequest.open("GET",`/teachers-app1/getTeachers`,true);
            ajaxRequest.send();

            ajaxRequest.onreadystatechange = function(){
                if(ajaxRequest.readyState === 4){
                    if(ajaxRequest.status === 200){
                        const data = JSON.parse(ajaxRequest.responseText);
                        createTbody(data);
                    }else{
                        console.log('Error');
                    }
                }
            }
    }

    function fetchStudentsFromJSON(){
            let ajaxRequest = new XMLHttpRequest();

            ajaxRequest.open("GET",`/teachers-app1/getStudents`,true);
            ajaxRequest.send();

            ajaxRequest.onreadystatechange = function(){
                if(ajaxRequest.readyState === 4){
                    if(ajaxRequest.status === 200){
                        const data = JSON.parse(ajaxRequest.responseText);
                        createSbody(data);
                    }else{
                        console.log('Error');
                    }
                }
            }
    }

    function fetchCoursesFromJSON(){
        let ajaxRequest = new XMLHttpRequest();

        ajaxRequest.open("GET",`/teachers-app1/getCourses`,true);
        ajaxRequest.send();

        ajaxRequest.onreadystatechange = function(response){
            if(ajaxRequest.readyState === 4){
                if(ajaxRequest.status === 200){
                    const data = JSON.parse(ajaxRequest.responseText);
                    createCbody(data);
                }else{
                    console.log('Error');
                }
            }
        }
    } 

    
    function createCbody(data){

        $("#cTable > tbody").empty();

        var len = data.length;

        for (var i=0; i<len; i++){
            var id = data[i].id;
            var title = data[i].title; 
            var description = data[i].description;
            var teacherId = data[i].teacherId;
            

            var tr_str = "<tr>" +
                "<td>" + id + "</td>" +
                "<td>" + title + "</td>" +
                "<td>" + description + "</td>" +
                "<td>" + teacherId + "</td>" +
                "<td>" +
                    "<button class='btnUpdate btn btn-primary' value=\'"+id+"\'>Τροποποίηση</button> " +
                    "<button class='btnDelete btn btn-primary' value=\'"+id+"\'>Διαγραφή</button>" +
                "</td>" + 
                "</tr>";

            $("#cTable tbody").append(tr_str);
        }
    }


       
    function createTbody(data){

        $("#userTable > tbody").empty();

        var len = data.length;

        for (var i=0; i<len; i++){
            var id = data[i].id;
            var emailId = data[i].emailId;
            var firstname = data[i].firstname;
            var lastname = data[i].lastname;
            var subject = data[i].subject;
            var rank = data[i].rank;
            

            var tr_str = "<tr>" +
                "<td>" + id + "</td>" +
                "<td>" + emailId + "</td>" +
                "<td>" + firstname + "</td>" +
                "<td>" + lastname + "</td>" +
                "<td>" + subject + "</td>" +
                "<td>" + rank + "</td>" +
                "<td>" +
                    "<button class='btnUpdate btn btn-primary' value=\'"+id+"\'>Τροποποίηση</button> " +
                    "<button class='btnDelete btn btn-primary' value=\'"+id+"\'>Διαγραφή</button>" +
                "</td>" + 
                "</tr>";

            $("#userTable tbody").append(tr_str);
        }
    }

    function createSbody(data){

        $("#usersTable > tbody").empty();

        var len = data.length;
        for (var i=0; i<len; i++){
            var id = data[i].id;
            var emailId = data[i].emailId;
            var firstname = data[i].firstname;
            var lastname = data[i].lastname;
            var rank = data[i].rank;
            var university = data[i].university;
            

            var tr_str = "<tr>" +
                "<td>" + id + "</td>" +
                "<td>" + emailId + "</td>" +
                "<td>" + firstname + "</td>" +
                "<td>" + lastname + "</td>" +
                "<td>" + rank + "</td>" +
                "<td>" + university + "</td>" +
                "<td>" +
                    "<button class='btnUpdate btn btn-primary' value=\'"+id+"\'>Τροποποίηση</button> " +
                    "<button class='btnDelete btn btn-primary' value=\'"+id+"\'>Διαγραφή</button>" +
                "</td>" + 
                "</tr>";

            $("#usersTable tbody").append(tr_str);
        }
    }

    

   

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.todo.todo.model.User" %><%-- --%>
<%@ page import="java.util.Collection" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bootstrap Example</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script><!-- Подключаем сценарии -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <script src="scripts/sendGreeting.js"></script>
    <script src="scripts/validate.js"></script>
    <script src="scripts/add.js"></script>
    <script src="scripts/doneFalse.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>AJAX</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<%--<script type="text/javascript"> <!--start -->--%>
<%--$(document).ready(function () {--%>
<%--    sendGreeting();--%>
<%--});--%>
<%--</script>--%>

<title>TO DO</title>

<H1>TO DO</H1> TO DO
<div class="fixed-top">
    <div class="collapse" id="navbarToggleExternalContent">
        <div class="bg-dark p-4">
            <h5 class="text-white h4"> Ознакомьтесь, пожалуйста с правилами! </h5>
            <span class="text-muted"> Для просмотра/внесения записей необходимо войти под своей авторизацией или зарегистирироваться </span>
        </div>
    </div>
    <nav class="navbar navbar-dark bg-dark" aria-labelledby="">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent"
                aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </nav>
</div>
<br>
<br>
<br>
<body>
<div class="row">
        <ul class="nav">
            <br>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/reg.do">Регистрация</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp"> Авторизация </a>
            </li>
        </ul>
    <div class="container">
        <form class=" need -validation " novalidate>
            <div class="form-group">
                <div class="col-md-6 mb-3">

                    <label for="validationDefault01">Добавить новое задание</label>
                    <textarea class="form-control" id="validationDefault01" rows="5"></textarea>
                </div>
                <div class="form-row">
                    <div class="col-md-3 mb-3">
                        <label for="validationDefault02">Category</label>
                        <select class="custom-select" id="validationDefault02" required>
                            <option selected disabled value="">Choose...</option>
                            <option>normal</option>
                            <option>hard</option>
                            <option>important</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row"> <!-- type="submit"-->
                        <button id="btn" class="btn btn-primary" onclick="add()"> Submit form</button>
                    </div>
                </div>
                <div class="row float-right">
                    <script>
                        $('#btn').click(function () {
                            add();
                        });
                    </script>
                </div>
            </div>
            <br>
            <div class="custom-control custom-switch">
                <input type="checkbox" class="custom-control-input" id="checkbox">
                <label class="custom-control-label" for="checkbox">Show all elements</label>
            </div>
            <p id="text" style="display: none;">Каждый веб-разработчик знает, что такое текст-«рыба».
                Текст этот, несмотря на название, не имеет никакого отношения к обитателям водоемов.
                Используется он веб-дизайнерами для вставки на интернет-страницы и демонстрации внешнего вида контента,
                просмотра шрифтов, абзацев, отступов и т.д. Так как цель применения такого текста
                исключительно демонстрационная, то и смысловую нагрузку ему нести совсем необязательно.
                Более того, нечитабельность текста сыграет на руку при оценке качества восприятия макета.</p>
            <script> <!--показать контент по нажатию  $('#text').show(100); если не активна то он скрыт $('#text').hide(100);-->
            $('#checkbox').click(function () {
                if ($(this).is(':checked')) {
                    $('#text').show(100);
                   doneFalse();
                } else {
                    location.reload();
                }
            });
            </script>
            <table id="table" class="table">
                <caption>list of notes according to the selected category</caption>
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Status</th>
                    <th scope="col">Description</th>
                    <th scope="col">Created</th>
                    <th scope="col">Category</th>
                </tr>
                </thead>
                <tbody>
                <div>

                </div>
                </tbody>
                <script><!--чекбокс/радиокнопка  состоянние true/false-->
                $('#checkbox').click(function () {
                    let checkboxStatus = $(this).prop('checked')
                    console.log(checkboxStatus);
                });
                </script>


            </table><!-- то что выбрали на радио кнопку-->
            <div class="row float-right">
                <script>
                    $('input').on('click', function () {
                        $('#outputField').text('Вы выбрали ' + $('input:checked').val());
                    });
                </script>
            </div>
            <nav class="navbar navbar-light bg-light">
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </nav>
        </form>
    </div>
</div>
</body>
</html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cinema</title>
    <style>
        h2 {
            padding: 10px 0;
            border-width: 0;
            border-radius: 1em;
            display: block;
            width: 1200px;
            height: 30px;
            margin: 200px auto 0;
            background: #60e6c5;
            color: black;
            font-size: 25px;
            outline: none;
            text-transform: uppercase;
            text-align: center;
        }
        .formAdd {
            padding: 5px 0;
            border-width: 0;
            border-radius: 1em;
            display: block;
            width: 1200px;
            height: 90px;
            margin: auto;
            background: #60e6c5;
            color: black;
            font-size: 20px;
            outline: none;
            text-transform: uppercase;
            text-align: center;
        }

        table {
            margin: auto; /* Выравниваем таблицу по центру */
        }
        .tables {
            width: auto;
            border: none;
            margin: auto;
            border-collapse: separate;
            text-align: center;
        }
        .tables thead th {
            font-weight: bold;
            text-align: center;
            border: none;
            padding: 10px 15px;
            background: #EDEDED;
            font-size: 14px;
            border-top: 1px solid #ddd;
        }
        .tables tr th:first-child, .table tr td:first-child {
            border-left: 1px solid #ddd;
        }
        .tables tr th:last-child, .table tr td:last-child {
            border-right: 1px solid #ddd;
        }
        .tables thead tr th:first-child {
            border-radius: 20px 0 0 0;
        }
        .tables thead tr th:last-child {
            border-radius: 0 20px 0 0;
        }
        .tables tbody td {
            text-align: center;
            border: none;
            padding: 10px 15px;
            font-size: 14px;
            vertical-align: top;
        }
        .tables tbody tr:nth-child(even) {
            background: #F8F8F8;
        }
        .tables tbody tr:last-child td{
            border-bottom: 1px solid #ddd;
        }
        .tables tbody tr:last-child td:first-child {
            border-radius: 0 0 0 20px;
        }
        .tables tbody tr:last-child td:last-child {
            border-radius: 0 0 20px 0;
        }
    </style>
</head>
<body>

    <h2>Movies list</h2>
    <div class="tables">
        <table width="1200">
            <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Year</th>
                <th>Restriction</th>
                <th>Description</th>
                <th>Poster</th>
                <th>Add poster</th>
                <th>Delete</th>
            </tr>
            </thead>
        <tbody>
            <#list movies as movie>
            <tr>
                <td>${movie.id}</td>
                <td>${movie.title}</td>
                <td>${movie.yearOfRelease}</td>
                <td>${movie.ageRestrictions}</td>
                <td>${movie.description}</td>
                <td>
                    <img src='/admin/panel/films/image/${movie.id}' style="height: 100px; width: 150px;">
                </td>
                <td>
                <form method="post" action="/admin/panel/films/addPoster/${movie.id}" enctype="multipart/form-data">
                    <br>
                    <input type="file" name="file">
                    <button type="submit">Upload</button>
                </form>
                </td>
                <td><a href="/admin/panel/films/delete/${movie.id}">delete</a></td>-->
<#--                <td>-->
<#--                    <form method="post" action="/admin/panel/halls/update/${hall.id}" name="hall">-->
<#--                        <input title="Number of seats" placeholder="Seats" type="text" name="seats" size="4" required pattern="^[ 0-9]+$">-->
<#--                        <button type="submit">Update</button>-->
<#--                    </form>-->
<#--                </td>-->
            </tr>
            </#list>
        </tbody>
        </table>
    </div>
    <div class="formAdd">
    <form method="post" action="/admin/panel/films" name="movie">
        <p><b>Add film</b><br>
        <input title="Title" placeholder="Title" type="text" name="title" size="15" required pattern="^[0-9a-zA-Z ]+$">
        <input title="yearOfRelease" placeholder="Year of release" type="text" name="yearOfRelease" size="10" required pattern="^[0-9]+$">
        <input title="ageRestrictions" placeholder="Age restrictions" type="text" name="ageRestrictions" size="10" required pattern="^[0-9]+$">
        <input title="description" placeholder="Description" type="text" name="description" size="20" required >
        <button type="submit">Add film</button>
    </form>
    </div>
</body>
</html>

<#--<div class="addMovies">-->
<#--    <form:form method="post" action="/admin/films" enctype="multipart/form-data" modelAttribute="movie">-->
<#--        <form:label cssStyle="background-color: darkgray" path="title">Название</form:label>-->
<#--        <form:input path="title"></form:input>-->
<#--        <form:label cssStyle="background-color: darkgray" path="dateOfRelease">Дата выпуска</form:label>-->
<#--        <input type="date" pattern="yyyy-MM-dd" name="releaseDate" required>-->
<#--        <form:label cssStyle="background-color: darkgray" path="restrictions">Ограничения по возрасту</form:label>-->
<#--        <form:input path="restrictions"></form:input>-->
<#--        <form:label cssStyle="background-color: darkgray" path="description">Описание</form:label>-->
<#--        <form:input path="description"></form:input>-->
<#--        <input type="file" name="file" accept="image/*" style="background-color: darkgrey">-->
<#--        <button type="submit">Добавить</button>-->
<#--    </form:form>-->
<#--</div>-->
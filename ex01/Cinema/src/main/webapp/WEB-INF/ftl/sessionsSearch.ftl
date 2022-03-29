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
            width: 800px;
            height: 30px;
            margin: 200px auto 0;
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

    <script
            src="https://code.jquery.com/jquery-2.2.4.js"
            integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
            crossorigin="anonymous"></script>
</head>
<body>

    <div class="formAdd">

    <form name="filmForm">
        <input title="FilmTitle" placeholder="Title" type="text" id="input" size="40" required pattern="^[0-9a-zA-Z]+$">
        <input type="button" value="Find" id="but">
    </form>
    </div>
    <div id="main">
    <script>
        $("#but").click(function call() {
            $.ajax({
                url: "/sessions/search",
                type: "GET",
                data: {"filmName": $("#input").val()},
                success: function (data) {
                    document.getElementById("main").innerHTML = "";
                    var sessionsArray = JSON.parse(data);
                    table = document.createElement("table");
                    console.log("Film: " + data);
                    console.log("Found: " + sessionsArray.length);
                    for (var i = 0; i < sessionsArray.length; i++) {
                        var trr = table.insertRow();
                        var tdd3 = trr.insertCell();
                        var img = new Image(200, 100);
                        img.src = "/sessions/search/image/" + sessionsArray[i].film.id;
                        tdd3.appendChild(img);
                    }
                    document.getElementById("main").appendChild(table);
                }
            });
        });
    </script>
    </div>

</body>
</html>

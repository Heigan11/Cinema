<html lang="en">
<head>
    <head>
        <title>Chat WebSocket</title>
</head>
    <script>
        let movieId = ${movie.id};
        let cinemausername = "${user.name}";
    </script>
    <div id="chat-page" class="chat" style="background-color: #9E9C9C">
        <div id="messageArea"></div>
    </div>
    <form id="messageForm" name="messageForm">
        <div class="form-group">
            <div class="input-group clearfix">
                <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                <button type="submit" class="primary">Send</button>
            </div>
        </div>
    </form>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.0/sockjs.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
    <script src="/js/main.js"></script>
<body>

</body>
</html>

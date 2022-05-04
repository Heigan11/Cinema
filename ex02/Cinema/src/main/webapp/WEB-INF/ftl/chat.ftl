<html lang="en">
<head>
    <head>
        <style>
            a {
                padding: 10px 0;
                border-width: 0;
                border-radius: 1em;
                display: block;
                width: 500px;
                height: 30px;
                margin: auto;
                background: #60e6c5;
                color: black;
                font-size: 25px;
                outline: none;
                text-transform: uppercase;
                text-align: center;
            }
            .bubbleWrapper {
                padding: 10px 10px;
                display: flex;
                justify-content: flex-end;
                flex-direction: column;
                align-self: flex-end;
                color: #fff;
                overflow-x: auto;
            }
            .inlineContainer {
                display: inline-flex;
            }
            .inlineContainer.own {
                flex-direction: row-reverse;
            }
            .inlineIcon {
                width:20px;
                object-fit: contain;
            }
            .ownBubble {
                min-width: 60px;
                max-width: 700px;
                padding: 14px 18px;
                margin: 6px 8px;
                background-color: #5b5377;
                border-radius: 16px 16px 0 16px;
                border: 1px solid #443f56;
            }

            .otherBubble {
                min-width: 60px;
                max-width: 700px;
                padding: 14px 18px;
                margin: 6px 8px;
                background-color: #6C8EA4;
                border-radius: 16px 16px 16px 0;
                border: 1px solid #54788e;

            }
            .own {
                align-self: flex-end;
            }
            .other {
                align-self: flex-start;
            }
            span.own,
            span.other{
                font-size: 14px;
                color: grey;
            }

            label.chat {
                font-size: large;
            }

            div.chat {
                height: 30%;
                overflow-x: auto;
                width: 50%;
                margin-left: 30%;
            }
        </style>
        <title>Chat WebSocket</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.0/sockjs.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
        <script type="text/javascript">
            var stompClient = null;

            function setConnected(connected) {
                document.getElementById('connect').disabled = connected;
                document.getElementById('disconnect').disabled = !connected;
                document.getElementById('conversationDiv').style.visibility
                    = connected ? 'visible' : 'hidden';
                document.getElementById('response').innerHTML = '';
            }

            function connect() {
                var socket = new SockJS('/ws');
                stompClient = Stomp.over(socket);
                stompClient.connect({}, function(frame) {
                    setConnected(true);
                    console.log('Connected: ' + frame);
                    stompClient.subscribe('/topic/public', function(message) {
                        showMessageOutput(JSON.parse(message.body));
                    });
                    <#--var historyMessage = ${history.get(0)};-->
                    <#--printMessage(${history.get(0)});-->
                });
            }

            function disconnect() {
                if(stompClient != null) {
                    stompClient.disconnect();
                }
                setConnected(false);
                console.log("Disconnected");
            }

            function sendMessage() {
                var message = {
                    sender: "${user.name}",
                    text: document.getElementById('text').value,
                    movie: { id: ${movie.id}}
                };
                stompClient.send("/app/chat", {}, JSON.stringify(message));
            }

            function printMessage(historyMessage) {
                var message = {
                    sender: historyMessage.sender,
                    text: historyMessage.text,
                    movie: { id: ${movie.id}}
                };
                stompClient.send("/app/chat", {}, JSON.stringify(message));
            }

            function showMessageOutput(message) {
                // var response = document.getElementById('response');
                // var p = document.createElement('p');
                // p.style.wordWrap = 'break-word';
                // p.appendChild(document.createTextNode(message.sender + ": "
                //     + message.text));
                // response.appendChild(p);

                var messageElement = document.createElement('div');
                messageElement.className = 'bubbleWrapper';

                var container = document.createElement('div');
                if (message.sender === "${user.name}")
                    container.className = 'inlineContainer own';
                else
                    container.className = 'inlineContainer';

                var usernameText = document.createElement('label');
                usernameText.textContent = message.sender;
                if (message.sender === "${user.name}")
                    usernameText.hidden = true;

                var textElement = document.createElement('div');
                if (message.sender === "${user.name}")
                    textElement.className = 'ownBubble own';
                else
                    textElement.className = 'otherBubble other';

                textElement.textContent = message.text;
                messageArea.appendChild(messageElement);
                messageElement.appendChild(container);
                container.appendChild(usernameText);
                container.appendChild(textElement);
            }
        </script>
</head>
<body onload="disconnect()">
<div>
    <a> ${movie.title}'s CHAT </a>
    <br />
    <div>

        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">
            Disconnect
        </button>

    </div>
    <br/>
    <div id="chat-page" class="chat" style="background-color: #9E9C9C">
        <div id="messageArea">
<#--            <#list history as message>-->
<#--                <script>-->
<#--                    printMessage(${message});-->
<#--                </script>-->
<#--                ${message.sender}: ${message.text}-->
<#--                <br/>-->
<#--            </#list>-->
        </div>
    </div>
    <div id="conversationDiv">
        <input type="text" id="text" placeholder="Write a message..."/>
        <button id="sendMessage" onclick="sendMessage();">Send</button>
        <br/>
        <p id="response"></p>
    </div>
</div>
</body>
</html>

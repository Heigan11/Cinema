'use strict';
var chatPage = document.querySelector('#chat-page');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');
var stompClient = null;
var username = null;

function connect(event) {
    username = cinemausername;
    if(username) {
        chatPage.classList.remove('hidden');
        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}
function onConnected() {
    stompClient.subscribe('/topic/public', onMessageReceived);
}
function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}
function sendMessage(event) {
    var messageContent = messageInput.value.trim();
    if(messageContent && stompClient) {
        var message = {
            sender: username,
            text: messageInput.value,
            movie: { id: movieId}
        };
        stompClient.send("/app/chat", {}, JSON.stringify(message));
        messageInput.value = '';
    }
    event.preventDefault();
}
function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    var messageElement = document.createElement('div');
    messageElement.className = 'bubbleWrapper';

    var container = document.createElement('div');
    if (message.sender === cinemausername)
        container.className = 'inlineContainer own';
    else
        container.className = 'inlineContainer';

    var usernameText = document.createElement('label');
    usernameText.textContent = message.sender;
    if (message.sender === cinemausername)
        usernameText.hidden = true;

    var textElement = document.createElement('div');
    if (message.sender === cinemausername)
        textElement.className = 'ownBubble own';
    else
        textElement.className = 'otherBubble other';
    textElement.textContent = message.text;
    messageArea.appendChild(messageElement);
    messageElement.appendChild(container);
    container.appendChild(usernameText);
    container.appendChild(textElement);

}

messageForm.addEventListener('submit', sendMessage, true)
document.addEventListener("DOMContentLoaded", connect)
<#--<!doctype html>-->
<#--<html lang="en">-->
<#--<head>-->
<#--    <meta charset="UTF-8">-->
<#--    <meta name="viewport"-->
<#--          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">-->
<#--    <meta http-equiv="X-UA-Compatible" content="ie=edge">-->
<#--    <title>Messages</title>-->

<#--    <script-->
<#--            src="https://code.jquery.com/jquery-3.4.1.js"-->
<#--            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="-->
<#--            crossorigin="anonymous"></script>-->

<#--    <script>-->
<#--        var webSocket;-->
<#--        function connect() {-->
<#--            webSocket = new WebSocket('ws://localhost:8080/chat');-->

<#--            webSocket.onmessage = function receiveMessage(response) {-->
<#--                var data = response['data'];-->
<#--                var json = JSON.parse(data);-->
<#--                $('#messagesList').first().after("<li>" + json['from'] + ' ' + json['text'] + "</li>")-->
<#--            }-->
<#--        }-->

<#--        function sendMessage(text, userId, roomId) {-->
<#--            var message = {-->
<#--                "text": text,-->
<#--                "from": userId-->
<#--                "room": roomId-->
<#--            };-->

<#--            webSocket.send(JSON.stringify(message));-->
<#--        }-->
<#--    </script>-->


<#--</head>-->

<#--<body onload="connect()">-->

<#--<h2>-->
<#--    Chat with <br>-->
<#--    ${with.firstName} ${with.secondName}-->
<#--</h2>-->

<#--<input type="text" placeholder="You'r message...">-->

<#--<button onclick="sendMessage($('#message').val(), '${with.userId}' , '${roomId}')">Send</button>-->

<#--<h3>Сообщения</h3>-->
<#--<ul id="messagesList">-->

<#--</ul>-->

<#--<ul>-->
<#--    <#list messages as message>-->

<#--        <li>-->
<#--            <p>-->
<#--                ${message.text}-->
<#--            </p>-->
<#--        </li>-->

<#--    </#list>-->
<#--</ul>-->

<#--</body>-->
<#--</html>-->

<#--<!doctype html>-->
<#--<html lang="en">-->
<#--<head>-->
<#--    <meta charset="UTF-8">-->
<#--    <meta name="viewport"-->
<#--          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">-->
<#--    <meta http-equiv="X-UA-Compatible" content="ie=edge">-->
<#--    <title>Чат</title>-->
<#--    <script-->
<#--            src="https://code.jquery.com/jquery-3.4.1.js"-->
<#--            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="-->
<#--            crossorigin="anonymous"></script>-->
<#--    <script>-->
<#--        var webSocket;-->
<#--        function connect() {-->
<#--            webSocket = new WebSocket('ws://localhost:8086/dialog/room/' + 1);-->

<#--            document.cookie = 'X-Authorization=' + '12345' + ';path=/';-->

<#--            webSocket.onmessage = function receiveMessage(response) {-->
<#--                var data = response['data'];-->
<#--                var json = JSON.parse(data);-->
<#--                $('#messagesList').first().after("<li>" + json['from'] + ' ' + json['text'] + "</li>")-->
<#--            }-->
<#--        }-->

<#--        function sendMessage(text, pageId) {-->
<#--            var message = {-->
<#--                "text": text,-->
<#--                "from": pageId-->
<#--            };-->

<#--            webSocket.send(JSON.stringify(message));-->
<#--        }-->
<#--    </script>-->
<#--</head>-->
<#--<body onload="connect()">-->
<#--<div>-->
<#--    <label for="message">Текст сообщения</label>-->
<#--    <input name="message" id="message" placeholder="Сообщение">-->
<#--    <button onclick="sendMessage($('#message').val(), '${pageId}')">Отправить</button>-->
<#--    <h3>Сообщения</h3>-->
<#--    <ul id="messagesList">-->

<#--    </ul>-->
<#--</div>-->
<#--</body>-->
<#--</html>-->
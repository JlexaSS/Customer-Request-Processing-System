<!DOCTYPE HTML>
<html>
<head>
    <title>Обработчик заявок</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<form method="post" action="/">
    <label for="client">Клиент</label>
    <select name="client">
        <#list clients as client>
            <option value="${client.getId()}">${client.getFirstName()}</option>
        </#list>
    </select>
    <label for="user">Пользователь</label>
    <select name="user">
        <#list users as user>
            <option value="${user.getId()}">${user.getFirstName()}</option>
        </#list>
    </select>
    <label for="type">Тип заявки</label>
    <select name="type">
        <#list types as key, val>
            <option value="${key}">${val}</option>
        </#list>
    </select>
    <button type="submit">Отправить</button>
</form>
</body>
</html>
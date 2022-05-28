<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="css" required="false" rtexprvalue="true" type="java.lang.String"%>

<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <style>
        <%@include file="../css/main.css"%>
    </style>
</head>
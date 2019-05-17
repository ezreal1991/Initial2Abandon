<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset='utf-8'/>
    <meta name='description' content=''/>
    <meta name='robots' content='noodp, noydir'/>
    <meta name='viewport' content='width=device-width, initial-scale=1'/>
    <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600'
          rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">

    <link href='http://extentreports.com/resx/dist/css/extent.css'
          type='text/css' rel='stylesheet'/>

    <title>TestReport</title>

    <style type='text/css'>
        .node.level-1 ul {
            display: none;
        }

        .node.level-1.active ul {
            display: block;
        }

        .card-panel.environment th:first-child {
            width: 30%;
        }
    </style>
</head>

<body class='extent standard default hide-overflow dark'>
<nav class="container">
    <div class="nav-wrapper">
        <!-- report name -->
        <span class='report-name'>${name }</span>
        <!-- report headline -->
        <span class='report-headline'></span>
        <!-- nav-right -->

    </div>
</nav>
<!-- container -->
<div class="container">
    <div id='test-view'>
        <div id='test-view-charts' class='subview-full'>
            <div id='charts-row' class='row nm-v nm-h'>
                <div class='col s12 m6 l6 np-h'>
                    <div class='card-panel nm-v'>
                        <div class='left panel-name'>Tests</div>
                        <div class='chart-box'>
                            <canvas id='parent-analysis' width='100' height='10'></canvas>
                        </div>
                        <div style="margin-left: 25px">
                            run testcase: <br/>
                        </div>
                        <div class='block text-small' style="margin-left: 80px">
									<span class='tooltipped' data-position='top'> total:
                                        ${caseNum }<br/> pass: ${passNum }<br/> fail: ${failNum }<br/>warning:
                                        ${warningNum }<br/>error: ${errorNum }<br/>
									</span>
                        </div>
                    </div>
                </div>
                <div class='col s12 m6 l6 np-h'>
                    <div class='card-panel nm-v'>
                        <div class='left panel-name'>Suites</div>
                        <div class='chart-box'>
                            <canvas id='child-analysis' width='100' height='10'></canvas>
                        </div>
                        <div style="margin-left: 25px">
                            interface result:<br/>
                        </div>
                        <div class='block text-small' style="margin-left: 90px">
                            <span id="pass_suites" class='tooltipped' data-position='top'>
                                total: ${iNum }<br/> pass: ${ipassNum }<br/> fail:
                                ${ifailNum }<br/>warning: ${iwarningNum }<br/>error:
                                ${ierrorNum }<br/>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class='subview-left left' style="width: 33%">
            <div class='view-summary'>
                <h5>Suites</h5>
                <table>
                    <tr>
                        <td>name</td>
                        <td>level</td>
                        <td>result</td>
                    </tr>
                    <c:forEach items="${resultList }" var="testcase">
                        <c:if test="${testcase.caseResult == 'error' }">
                            <tr>
                                <td>
                                    <span class="red-text"> <a style='color: red'
                                                               href="javascript:void(0)"
                                                               onclick="showDetail('${testcase.name}')">${testcase.name}</a>
							        </span>
                                </td>
                                <td>
                                    <span class="red-text">${testcase.level}</span>
                                </td>
                                <td>
                                    <span class="red-text">error</span>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${resultList }" var="testcase">
                        <c:if test="${testcase.caseResult == 'fail' }">
                            <tr>
                                <td>
                                    <span class="red-text">  <a style='color: red'
                                                                href="javascript:void(0)"
                                                                onclick="showDetail('${testcase.name}')">${testcase.name}</a>
							        </span>
                                </td>
                                <td>
                                    <span class="red-text">${testcase.level}</span>
                                </td>
                                <td>
                                    <span class="red-text">fail</span>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${resultList }" var="testcase">
                        <c:if test="${testcase.caseResult == 'warning' }">
                            <tr>
                                <td>
                                    <span class="yellow-text">  <a style='color: yellow'
                                                                   href="javascript:void(0)"
                                                                   onclick="showDetail('${testcase.name}')">${testcase.name}</a>
							        </span>
                                </td>
                                <td>
                                    <span class="yellow-text">${testcase.level}</span>
                                </td>
                                <td>
                                    <span class="yellow-text">warning</span>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${resultList }" var="testcase">
                        <c:if test="${testcase.caseResult == 'pass' }">
                            <tr>
                                <td>
                                    <span class="green-text">  <a style='color: green'
                                                                  href="javascript:void(0)"
                                                                  onclick="showDetail('${testcase.name}')">${testcase.name}</a>
							        </span>
                                </td>
                                <td>
                                    <span class="green-text">${testcase.level}</span>
                                </td>
                                <td>
                                    <span class="green-text">pass</span>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
        </div>
        <!-- subview left -->
        <div class='subview-right right' style="width: 65%">
            <div class='view-summary'
                 style='overflow-y: auto; overflow-x: hidden; height: 730px; word-wrap: break-word; word-break: break-all;'>
                <h5 class='test-name'>detail</h5>
                <c:forEach items="${resultList }" var="testcase"
                           varStatus="varStatus">
                    <div id="${testcase.name }" name="detail">
                        <c:if test="${testcase.caseResult == 'error' }">
								<span class="red-text"> <br/>${testcase.name}<br/>
								</span>
                        </c:if>
                        <c:if test="${testcase.caseResult == 'fail' }">
								<span class="red-text"> <br/>${testcase.name}<br/>
								</span>
                        </c:if>
                        <c:if test="${testcase.caseResult == 'warning' }">
								<span class="yellow-text"> <br/>${testcase.name}<br/>
								</span>
                        </c:if>
                        <c:if test="${testcase.caseResult == 'pass' }">
								<span class="green-text"> <br>${testcase.name}<br/>
								</span>
                        </c:if>
                        <c:forEach items="${testcase.totalList }" var="interfaceinf">
                            <c:if test="${interfaceinf.interfaceResult  == 'error'}">
                                <span class="red-text"> error</span>
                                <span style="margin-left: 20px">${interfaceinf.name }
                                        ${interfaceinf.startTime }</span>
                                <span style="margin-left: 20px">time:
										${interfaceinf.actualMs }ms<br/>url: ${interfaceinf.url }<br/>返回值：
                                        ${interfaceinf.jsonResult }<br/> <br/>
									</span>
                            </c:if>
                            <c:if test="${interfaceinf.interfaceResult  == 'fail'}">
                                <span class="red-text"> ${interfaceinf.name }</span>
                                <span style="margin-left: 20px" class="red-text">fail</span>
                                <span style="margin-left: 20px">${interfaceinf.startTime }</span>
                                <span style="margin-left: 20px">time:
										${interfaceinf.actualMs }ms<br/>url: ${interfaceinf.url }<br/>返回值：
                                        ${interfaceinf.jsonResult }<br/>
								</span>
                                <span class="red-text"> ${interfaceinf.msg }</span><br/><br/>
                            </c:if>
                            <c:if test="${interfaceinf.interfaceResult  == 'warning'}">
                                <span class="yellow-text"> warning</span>
                                <span style="margin-left: 20px">${interfaceinf.name }
                                        ${interfaceinf.startTime }</span>
                                <span style="margin-left: 20px">time:
										${interfaceinf.actualMs }ms<br/>url: ${interfaceinf.url }<br/>返回值：
                                        ${interfaceinf.jsonResult }<br/> <br/>
                                </span>
                            </c:if>
                            <c:if test="${interfaceinf.interfaceResult  == 'pass'}">
                                <span class="green-text">${interfaceinf.name }</span>
                                <span class="green-text" style="margin-left: 20px"> pass</span>
                                <span style="margin-left: 20px">
                                        ${interfaceinf.startTime }</span>
                                <span style="margin-left: 20px">time:
										${interfaceinf.actualMs }ms<br/>url: ${interfaceinf.url }<br/>返回值：
                                        ${interfaceinf.jsonResult }<br/> <br/>
									</span>
                            </c:if>
                        </c:forEach>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    window.onload = function () {
        var divs = document.getElementsByName("detail");
        for (var i = 1; i < divs.length; i++) {
            divs[i].style.display = "none";
        }
    }

    function showDetail(name) {
        var divs = document.getElementsByName("detail");
        for (var i = 0; i < divs.length; i++) {
            divs[i].style.display = "none";
        }
        document.getElementById(name).style.display = "";
    }
</script>
</html>
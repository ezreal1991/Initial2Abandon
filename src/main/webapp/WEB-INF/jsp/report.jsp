<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8' />
<meta name='description' content='' />
<meta name='robots' content='noodp, noydir' />
<meta name='viewport' content='width=device-width, initial-scale=1' />
<meta id="timeStampFormat" name="timeStampFormat"
	content='MMM d, yyyy hh:mm:ss a' />

<link
	href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600'
	rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link href='http://extentreports.com/resx/dist/css/extent.css'
	type='text/css' rel='stylesheet' />

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
	<div id='theme-selector' alt='切换主题，默认黑色' title='切换主题'>
		<span><i class='material-icons'>desktop_windows</i></span>
	</div>

	<nav>
	<div class="nav-wrapper">
		<a href="#!" class="brand-logo blue darken-3">Extent</a>

		<!-- slideout menu -->
		<ul id='slide-out' class='side-nav fixed hide-on-med-and-down'>
			<li class='waves-effect active'><a href='#!' view='test-view'
				onclick="configureView(0);chartsView('test');"><i
					class='material-icons'>dashboard</i></a></li>
			<li class='waves-effect'><a href='#!' view='category-view'
				onclick="configureView(1)"><i class='material-icons'>label_outline</i></a></li>
			<li class='waves-effect'><a href='#!'
				onclick="configureView(-1);chartsView('dashboard');"
				view='dashboard-view'><i class='material-icons'>track_changes</i></a></li>
		</ul>

		<!-- report name -->
		<span class='report-name'>Test Report: Test Report 13时07分24秒</span>

		<!-- report headline -->
		<span class='report-headline'></span>

		<!-- nav-right -->
		<ul id='nav-mobile' class='right hide-on-med-and-down nav-right'>
			<li><a href='#!'> <span
					class='label suite-start-time blue darken-3'>{{
						time.start_datetime }}</span>
			</a></li>
		</ul>
	</div>
	</nav>

	<!-- container -->
	<div class='container'>
		<div id='test-view' class='view'>


			<div id='test-view-charts' class='subview-full'>

				<div id='test-view-charts' class='subview-full'>
					<div id='charts-row' class='row nm-v nm-h'>
						<div class='col s12 m6 l6 np-h'>
							<div class='card-panel nm-v'>
								<div class='left panel-name'>Tests</div>
								<div class='chart-box'>
									<canvas id='parent-analysis' width='100' height='10'></canvas>
								</div>
								<div style="margin-left: 25px">
									run testcase: <br />
								</div>
								<div class='block text-small' style="margin-left: 80px">
									<span class='tooltipped' data-position='top'> total:
										${caseNum }<br /> pass: ${passNum }<br /> fail: ${failNum }<br />warning:
										${warningNum }<br />error: ${errorNum }<br />
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
									interface result:<br />
								</div>
								<div class='block text-small' style="margin-left: 90px">
									<span id="pass_suites" class='tooltipped' data-position='top'>
										total: ${iNum }<br /> pass: ${ipassNum }<br /> fail:
										${ifailNum }<br />warning: ${iwarningNum }<br />error:
										${ierrorNum }<br />
									</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class='subview-left left' style="width: 33%">
				<div class='view-summary'>
					<h5>Suites</h5>
					<c:forEach items="${resultList }" var="testcase">
						<c:if test="${testcase.caseResult == 'error' }">
							<span class="red-text"> <br> <a style='color: red'
								href="javascript:void(0)"
								onclick="showDetail('${testcase.name}')">${testcase.name}</a>
							</span>
							<span class="red-text" style="float: right">error</span>
						</c:if>
					</c:forEach>
					<c:forEach items="${resultList }" var="testcase">
						<c:if test="${testcase.caseResult == 'fail' }">
							<span class="red-text"> <br> <a style='color: red'
								href="javascript:void(0)"
								onclick="showDetail('${testcase.name}')">${testcase.name}</a>
							</span>
							<span class="red-text" style="float: right">fail</span>
						</c:if>
					</c:forEach>
					<c:forEach items="${resultList }" var="testcase">
						<c:if test="${testcase.caseResult == 'warning' }">
							<span class="yellow-text"> <br> <a
								style='color: #FFFF00' href="javascript:void(0)"
								onclick="showDetail('${testcase.name}')">${testcase.name}</a>
							</span>
							<span class="yellow-text" style="float: right">warning</span>
						</c:if>
					</c:forEach>
					<c:forEach items="${resultList }" var="testcase">
						<c:if test="${testcase.caseResult == 'pass' }">
							<span class="green-text"> <br> <a
								style='color: green' href="javascript:void(0)"
								onclick="showDetail('${testcase.name}')">${testcase.name}</a>
							</span>
							<span class="green-text" style="float: right">pass</span>
						</c:if>
					</c:forEach>
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
								<span class="red-text"> <br />${testcase.name}<br />
								</span>
							</c:if>
							<c:if test="${testcase.caseResult == 'fail' }">
								<span class="red-text"> <br />${testcase.name}<br />
								</span>
							</c:if>
							<c:if test="${testcase.caseResult == 'warning' }">
								<span class="yellow-text"> <br />${testcase.name}<br />
								</span>
							</c:if>
							<c:if test="${testcase.caseResult == 'pass' }">
								<span class="green-text"> <br>${testcase.name}<br />
								</span>
							</c:if>
							<c:forEach items="${testcase.totalList }" var="interfaceinf">
								<c:if test="${interfaceinf.interfaceResult  == 'error'}">
									<span class="red-text"> error</span>
									<span style="margin-left: 20px">${interfaceinf.name }
										${interfaceinf.startTime }</span>
									<span style="margin-left: 20px">time:
										${interfaceinf.actualMs }ms<br />url: ${interfaceinf.url }<br />返回值：
										${interfaceinf.jsonResult }<br /> <br />
									</span>
								</c:if>
								<c:if test="${interfaceinf.interfaceResult  == 'fail'}">
									<span class="red-text"> fail</span>
									<span style="margin-left: 20px">${interfaceinf.name }
										${interfaceinf.startTime }</span>
									<span style="margin-left: 20px">time:
										${interfaceinf.actualMs }ms<br />url: ${interfaceinf.url }<br />返回值：
										${interfaceinf.jsonResult }<br /> <br />
									</span>
								</c:if>
								<c:if test="${interfaceinf.interfaceResult  == 'warning'}">
									<span class="yellow-text"> warning</span>
									<span style="margin-left: 20px">${interfaceinf.name }
										${interfaceinf.startTime }</span>
									<span style="margin-left: 20px">time:
										${interfaceinf.actualMs }ms<br />url: ${interfaceinf.url }<br />返回值：
										${interfaceinf.jsonResult }<br /> <br />
									</span>
								</c:if>
								<c:if test="${interfaceinf.interfaceResult  == 'pass'}">
									<span class="green-text">${interfaceinf.name }</span>
									<span class="green-text" style="margin-left: 20px"> pass</span>
									<span style="margin-left: 20px">
										${interfaceinf.startTime }</span>
									<span style="margin-left: 20px">time:
										${interfaceinf.actualMs }ms<br />url: ${interfaceinf.url }<br />返回值：
										${interfaceinf.jsonResult }<br /> <br />
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
	window.onload = function() {
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
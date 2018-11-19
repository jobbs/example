<%--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 김동훈
 * @lastmodifier 김동훈
 * @created 2016. 9. 22.
 * @lastmodified 2016. 9. 22.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 9. 22.     김동훈         v1.0             최초생성
 *
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script>
	function f_openPop() {
		popup(
				'<c:url value="/dsb/thrd/thrdConf/dfltThrd/selectNtceConf.do" />',
				'NtceConfPop', 800);

	}
	function f_openPop1() {
		window.open('./임계치 설정 수정(UI-PTL-DS-027).html', '',
				'width=1020,height=500');
	}
</script>

<!-- col-box : 기본적으로 해당 가로사이즈(%)를 유지합니다. -->
<div class="col-box-100">
	<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
	<!-- box(검색조건) -->

	<!-- col-box : 기본적으로 해당 가로사이즈(%)를 유지합니다. -->
	<div class="col-box-100">
		<!-- box : 컨텐츠의 내용을 분류해주는 요소입니다. header(타이틀)와 body, footer로 나누어집니다. -->
		<!-- box(목록조회 테이블) -->
		<div class="nav-tabs-custom">

			<div class="tab-content">
				<!-- tab-pane : .tab-content 페이지 중 하나입니다. -->
				<!-- tab-pane 화면은 상단 .nav-tabs(탭메뉴)내 a태그 클릭시 하단 .tab-pane요소의 active클래스의 유무로 화면에 나타나게 됩니다. -->
				<div class="tab-pane active" id="tab-a">
					<section>
						<table class="table table-hover table-vertical table-bordered">
							<colgroup>
								<col class="col10">
								<col class="col10">
								<col class="col10">
								<col class="col10">
								<col class="col10">
								<col class="col10">
								<col class="colAuto">
								<col class="colAuto">
								<col>
							</colgroup>
							<thead>
								<tr>
									<th rowspan="2">서버구분</th>
									<th rowspan="2">상태</th>
									<th rowspan="2">등급</th>
									<th colspan="2">CPU</th>
									<th colspan="2">메모리</th>
									<th rowspan="2">통보설정</th>
									<th rowspan="2">수정</th>
								</tr>
								<tr>
									<th>사용률</th>
									<th>가상화율</th>
									<th>사용률</th>
									<th>가상화율</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td rowspan='2'>물리서버</td>
									<td rowspan='2'>Down(2)</td>
									<td>critical</td>
									<td>≥95</td>
									<td>≥300</td>
									<td>≥95</td>
									<td>≥300</td>
									<td rowspan="2"><a href="#" onclick='f_openPop()'>Down,Critical</a></td>
									<td rowspan="2"><button class="btn btn-blue" onclick='f_openPop1()'>임계치수정</button></td>
								</tr>
								<tr>
									<td>major</td>
									<td>≥90</td>
									<td>≥200</td>
									<td>≥90</td>
									<td>≥200</td>

								</tr>
								<tr>
									<td rowspan='2'>가상서버</td>
									<td rowspan='2'>Down(2)</td>
									<td>critical</td>
									<td>≥95</td>
									<td></td>
									<td>≥95</td>
									<td></td>
									<td rowspan="2"><button class="btn btn-blue">통보설정</button></td>
									<td rowspan="2"><button class="btn btn-blue">임계치수정</button></td>
								</tr>
								<tr>
									<td>major</td>
									<td>≥90</td>
									<td></td>
									<td>≥90</td>
									<td></td>

								</tr>
							</tbody>
						</table>
					</section>
				</div>
				<!-- /tab-pane -->
			</div>
			<!-- /tab-content -->
		</div>
		<!-- /nav-tabs-custom -->

	</div>
	<!-- /col -->
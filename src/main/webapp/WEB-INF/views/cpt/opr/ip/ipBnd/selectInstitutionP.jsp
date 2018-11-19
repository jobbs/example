<!--
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @author 신재훈
 * @lastmodifier 신재훈
 * @created 2016. 12. 19.
 * @lastmodified 2016. 12. 19.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 12. 19.     신재훈         v1.0             최초생성
 *
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="cf" uri="/WEB-INF/tags/cf"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tags/menu"%>
<%@ taglib prefix="nform" uri="/WEB-INF/tags/nform"%>

<div class="col-box-100 detail-col suttle-box suttle-horizon">
	<div class="col-cell-45 no-padding">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">목록1</h3>
				<div class="box-tools input-group-box">
					 <div class="input-group-cell pad-right-5">
					 	<div class="input-group">
					 		<select class="form-control input-sm">
					 			<option>전체</option>
					 			<option>ID</option>
					 			<option>사용자</option>
					 		</select>
					 	</div>
					</div>
					<div class="input-group-cell">
						<div class="input-group">
							<input type="text" name="table_search" class="form-control input-sm" placeholder="Search">
							<div class="input-group-btn">
								<button class="btn btn-sm"><i class="fa fa-search"></i></button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="box-body no-padding">
				<table class="table table-hover table-vertical">
					<colgroup>
						<col class="colAuto">
						<col class="col40">
						<col class="col40">
					</colgroup>
					<thead>
						<tr><th></th>
						<th>ID</th>
						<th>사용자</th>
						</tr></thead>
					<tbody>
						<tr>
							<td><input type="checkbox"></td>
							<td>id</td>
							<td>홍길동</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="box-footer clearfix">
			<ul class="pagination">
			</ul>
		</div>
	</div>


</div>

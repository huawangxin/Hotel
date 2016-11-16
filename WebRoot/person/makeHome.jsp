<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
		<script src="hotel/js/validation-framework.js"></script>
		<a href="${ctx}/loginMessage3.jsp">返回服务界面</a><br>
		<div align="center">
			预定房间
		<form id="form10" name="form10" method="post"
			action="${ctx}/servlet/makeHome"
			onsubmit="return doValidate(this)">
			<table width="400" border="0">
				<tr>
					<td width="87">
						房间号：
					</td>
					<td width="200">
						<label>
							<input name="id" type="text" id="id" size="20" />
						</label>
					</td>
					</tr>
					<tr>
					<td>
						姓名：
					</td>
					<td>
						<label>
							<input name="name" type="text" id="name" size="40"/>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						身份证号：
					</td>
					<td>
						<label>
							<input name="idcard" type="text" id="idcard" size="40" />
						</label>
					</td>
				</tr>
				<tr>
					<td>
						客房类型：
					</td>
					<td>
						<label>
							<input name="hometype" type="text" id="hometype" size="40" />
						</label>
					</td>
				</tr>
					<tr>
					<td>
						<label>
							<input type="submit" name="submit" id="submit" value="提交" />
						</label>
					</td>
					<td>
						<label>
							<input type="reset" name="reset" id="reset" value="重置" />
						</label>
					</td>
				</tr>
			</table>
		</form>
</div>
<%@ include file="/footer.htm"%>

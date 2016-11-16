<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="header.jsp"%>
<style>
* {
	font-family: "宋体";
	font-size: 14px
}
</style>
<script src="${ctx}/js/validation-framework.js"></script>
<form id="form1" name="form1" method="post"
	action="${ctx }/servlet/loginHotel" onsubmit="return doValidate(this)">
	<div align="center">
		<h2>
			登录界面
		</h2>
		<table width="280" border="0">
			<tr>
				<td width="99">
					用户名：
				</td>
				<td width="198">
					<label>
						<input name="name" type="text" id="name" size="20" maxlength="20" />
					</label>
				</td>
			</tr>
			<tr>
				<td>
					密码：
				</td>
				<td>
					<label>
						<input name="password" type="password" id="password" size="20"
							maxlength="20" />
					</label>
				</td>
			</tr>
			<tr>
				<td>
					<label>
						<input name="radio" type="radio" id="radio" value="person"
							checked="checked" />
						用户
					</label>
				</td>
				<td>
					<label>
						<input type="radio" name="radio" id="radio" value="manager" />
						管理员
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
	</div>
</form>
<%@ include file="/footer.htm"%>

<%@ page pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
		<script src="hotel/js/validation-framework.js"></script>
		<div align="center">
			添加职工信息
		<form id="form7" name="form7" method="post"
			action="${ctx}/servlet/addAdmin"
			onsubmit="return doValidate(this)">
			<table width="491" border="0">
				<tr>
					<td width="87">
						职工号：
					</td>
					<td width="394">
						<label>
							<input name="id" type="text" id="id" size="40" />
						</label>
					</td>
				</tr>
				<tr>
					<td>
						姓名：
					</td>
					<td>
						<label>
							<input name="name" type="text" id="name" size="40" />
						</label>
					</td>
				</tr>
				<tr>
					<td>
						密码：
					</td>
					<td>
						<label>
							<input name="password" type="text" id="password" size="40" />
						</label>
					</td>
				</tr>
				<tr>
					<td>
						身份：
					</td>
					<td>
						<select size="1" name="status">
						<option selected>person</option>
						<option>manager
						</select>
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

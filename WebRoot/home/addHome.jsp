<%@ page pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
		<script src="hotel/js/validation-framework.js"></script>
		<div align="center">
			增加客房信息
		<form id="form3" name="form3" method="post"
			action="${ctx}/servlet/addHome"
			onsubmit="return doValidate(this)">
			<table width="491" border="0">
				<tr>
					<td width="87">
						客房号：
					</td>
					<td width="394">
						<label>
							<input name="id" type="text" id="id" size="40" />
						</label>
					</td>
				</tr>
				<tr>
					<td>
						客房状态：
					</td>
					<td>
						<label>
							<input name="state" type="text" id="state" size="40" />
						</label>
					</td>
				</tr>
				<tr>
					<td>
						客房类型：
					</td>
					<td>
						<label>
							<input name="type" type="text" id="type" size="40" />
						</label>
					</td>
				</tr>
				<tr>
					<td>
						客房价格：
					</td>
					<td>
						<label>
							<input name="price" type="text" id="price" size="40" />
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

<%@ page pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
		<script src="hotel/js/validation-framework.js"></script>
		<div align="center">
			删除职工信息
		<form id="form6" name="form6" method="post"
			action="${ctx}/servlet/deleteAdmin"
			onsubmit="return doValidate(this)">
			<table width="400" border="0">
				<tr>
					<td width="87">
						职工号：
					</td>
					<td width="200">
						<label>
							<input name="id" type="text" id="id" size="20" />
						</label>
					</td>
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

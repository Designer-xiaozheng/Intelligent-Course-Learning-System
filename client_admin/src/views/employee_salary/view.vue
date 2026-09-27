<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','employee_no') || $check_field('add','employee_no') || $check_field('set','employee_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="员工工号" prop="employee_no">
													<el-select v-if="user_group === '管理员' || (form['employee_salary_id'] && $check_field('set','employee_no')) || (!form['employee_salary_id'] && $check_field('add','employee_no'))" id="employee_no" v-model="form['employee_no']" :disabled="disabledObj['employee_no_isDisabled']">
							<el-option v-for="o in list_user_employee_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','employee_no')" id="employee_no" v-model="form['employee_no']" :disabled="true">
							<el-option v-for="o in list_user_employee_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','employee_name') || $check_field('add','employee_name') || $check_field('set','employee_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="员工姓名" prop="employee_name">
												<el-input id="employee_name" v-model="form['employee_name']" placeholder="请输入员工姓名"
							  v-if="user_group === '管理员' || (form['employee_salary_id'] && $check_field('set','employee_name')) || (!form['employee_salary_id'] && $check_field('add','employee_name'))" :disabled="disabledObj['employee_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','employee_name')">{{form['employee_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','salary_month') || $check_field('add','salary_month') || $check_field('set','salary_month')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="发薪月份" prop="salary_month">
								<el-select id="salary_month" v-model="form['salary_month']"
						v-if="user_group === '管理员' || (form['employee_salary_id'] && $check_field('set','salary_month')) || (!form['employee_salary_id'] && $check_field('add','salary_month'))">
						<el-option v-for="o in list_salary_month" :key="o['pay_month']" :label="o['pay_month']"
							:value="o['pay_month']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','salary_month')">{{form['salary_month']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','base_pay') || $check_field('add','base_pay') || $check_field('set','base_pay')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="基本工资" prop="base_pay">
								<el-input-number id="base_pay" v-model.number="form['base_pay']"
						v-if="user_group === '管理员' || (form['employee_salary_id'] && $check_field('set','base_pay')) || (!form['employee_salary_id'] && $check_field('add','base_pay'))" :disabled="disabledObj['base_pay_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','base_pay')">{{form['base_pay']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','overtime_wage') || $check_field('add','overtime_wage') || $check_field('set','overtime_wage')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="加班工资" prop="overtime_wage">
								<el-input-number id="overtime_wage" v-model.number="form['overtime_wage']"
						v-if="user_group === '管理员' || (form['employee_salary_id'] && $check_field('set','overtime_wage')) || (!form['employee_salary_id'] && $check_field('add','overtime_wage'))" :disabled="disabledObj['overtime_wage_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','overtime_wage')">{{form['overtime_wage']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','bonus') || $check_field('add','bonus') || $check_field('set','bonus')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="奖金" prop="bonus">
								<el-input-number id="bonus" v-model.number="form['bonus']"
						v-if="user_group === '管理员' || (form['employee_salary_id'] && $check_field('set','bonus')) || (!form['employee_salary_id'] && $check_field('add','bonus'))" :disabled="disabledObj['bonus_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','bonus')">{{form['bonus']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','leave_days') || $check_field('add','leave_days') || $check_field('set','leave_days')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="请假天数" prop="leave_days">
												<el-input id="leave_days" v-model="form['leave_days']" placeholder="请输入请假天数"
							  v-if="user_group === '管理员' || (form['employee_salary_id'] && $check_field('set','leave_days')) || (!form['employee_salary_id'] && $check_field('add','leave_days'))" :disabled="disabledObj['leave_days_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','leave_days')">{{form['leave_days']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','days_of_absenteeism') || $check_field('add','days_of_absenteeism') || $check_field('set','days_of_absenteeism')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="旷班天数" prop="days_of_absenteeism">
												<el-input id="days_of_absenteeism" v-model="form['days_of_absenteeism']" placeholder="请输入旷班天数"
							  v-if="user_group === '管理员' || (form['employee_salary_id'] && $check_field('set','days_of_absenteeism')) || (!form['employee_salary_id'] && $check_field('add','days_of_absenteeism'))" :disabled="disabledObj['days_of_absenteeism_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','days_of_absenteeism')">{{form['days_of_absenteeism']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','fine') || $check_field('add','fine') || $check_field('set','fine')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="罚款" prop="fine">
								<el-input-number id="fine" v-model.number="form['fine']"
						v-if="user_group === '管理员' || (form['employee_salary_id'] && $check_field('set','fine')) || (!form['employee_salary_id'] && $check_field('add','fine'))" :disabled="disabledObj['fine_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','fine')">{{form['fine']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','attendance_deduction') || $check_field('add','attendance_deduction') || $check_field('set','attendance_deduction')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="考勤扣款" prop="attendance_deduction">
								<el-input-number id="attendance_deduction" v-model.number="form['attendance_deduction']"
						v-if="user_group === '管理员' || (form['employee_salary_id'] && $check_field('set','attendance_deduction')) || (!form['employee_salary_id'] && $check_field('add','attendance_deduction'))" :disabled="disabledObj['attendance_deduction_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','attendance_deduction')">{{form['attendance_deduction']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','net_salary') || $check_field('add','net_salary') || $check_field('set','net_salary')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="实发工资" prop="net_salary">
												<el-input id="net_salary" v-model="form['net_salary']" placeholder="请输入实发工资"
							  v-if="user_group === '管理员' || (form['employee_salary_id'] && $check_field('set','net_salary')) || (!form['employee_salary_id'] && $check_field('add','net_salary'))"  @focus="set_net_salary()" :disabled="disabledObj['net_salary_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','net_salary')">{{form['net_salary']}}</div>
											</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "employee_salary_id",
				url_add: "~/api/employee_salary/add?",
				url_set: "~/api/employee_salary/set?",
				url_get_obj: "~/api/employee_salary/get_obj?",
				url_upload: "~/api/employee_salary/upload?",

				query: {
					"employee_salary_id": 0,
				},

				form: {
								"employee_no": 0, // 员工工号
										"employee_name":  '', // 员工姓名
										"salary_month":  '', // 发薪月份
										"base_pay":  0, // 基本工资
										"overtime_wage":  0, // 加班工资
										"bonus":  0, // 奖金
										"leave_days":  '', // 请假天数
										"days_of_absenteeism":  '', // 旷班天数
										"fine":  0, // 罚款
										"attendance_deduction":  0, // 考勤扣款
										"net_salary":  '', // 实发工资
											"employee_salary_id": 0, // ID
						
				},
				disabledObj:{
								"employee_no_isDisabled": false,
										"employee_name_isDisabled": false,
										"salary_month_isDisabled": false,
					          			"base_pay_isDisabled": false,
					          			"overtime_wage_isDisabled": false,
					          			"bonus_isDisabled": false,
										"leave_days_isDisabled": false,
										"days_of_absenteeism_isDisabled": false,
					          			"fine_isDisabled": false,
					          			"attendance_deduction_isDisabled": false,
										"net_salary_isDisabled": false,
										},

	
					// 用户列表
				list_user_employee_no: [],
				
						// 发薪月份选项列表
				list_salary_month: [""],
	
		
		
		
		
		
		
		
		
	
			}
		},
		methods: {


	
	
				/**
			 * 获取员工用户列表
			 */
			async get_list_user_employee_no() {
                // if(this.user_group !== "管理员" && this.form["employee_no"] === 0) {
                //     this.form["employee_no"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=员工");
                if(json.result && json.result.list){
                    this.list_user_employee_no = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_employee_no(id){
				var obj = this.list_user_employee_no.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
				/**
			 * 获取发薪月份列表
			 */
			async get_list_salary_month() {
				var json = await this.$get("~/api/pay_month/get_list?");
				if(json.result && json.result.list){
					this.list_salary_month = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
										set_net_salary(){
				this.form.net_salary = parseFloat(this.form.base_pay) + parseFloat(this.form.overtime_wage) + parseFloat(this.form.bonus) - parseFloat(this.form.fine) - parseFloat(this.form.attendance_deduction)
			},
						
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																																	
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																										$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																																	

			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																																							return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/employee_salary/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/employee_salary/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/employee_salary/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/employee_salary/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/employee_salary/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
					this.get_list_user_employee_no();
									this.get_list_salary_month();
																				},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>

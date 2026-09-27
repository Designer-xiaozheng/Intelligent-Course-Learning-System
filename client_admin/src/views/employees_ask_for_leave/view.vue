<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','employee_no') || $check_field('add','employee_no') || $check_field('set','employee_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="员工工号" prop="employee_no">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_employee_no(form['employee_no']) }}
							<!--<el-input id="business_name" v-model="form['employee_no']" placeholder="请输入员工工号"-->
							<!--v-if="user_group === '管理员' || (form['employees_ask_for_leave_id'] && $check_field('set','employee_no')) || (!form['employees_ask_for_leave_id'] && $check_field('add','employee_no'))" :disabled="disabledObj['employee_no_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','employee_no')">{{form['employee_no']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['employees_ask_for_leave_id'] && $check_field('set','employee_no')) || (!form['employees_ask_for_leave_id'] && $check_field('add','employee_no'))" id="employee_no" v-model="form['employee_no']" :disabled="disabledObj['employee_no_isDisabled']">
								<el-option v-for="o in list_user_employee_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','employee_no')" id="employee_no" v-model="form['employee_no']" :disabled="true">
								<el-option v-for="o in list_user_employee_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="employee_no" v-model="form['employee_no']" :disabled="disabledObj['employee_no_isDisabled']">
							<el-option v-for="o in list_user_employee_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','employee_name') || $check_field('add','employee_name') || $check_field('set','employee_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="员工姓名" prop="employee_name">
												<el-input id="employee_name" v-model="form['employee_name']" placeholder="请输入员工姓名"
							  v-if="user_group === '管理员' || (form['employees_ask_for_leave_id'] && $check_field('set','employee_name')) || (!form['employees_ask_for_leave_id'] && $check_field('add','employee_name'))" :disabled="disabledObj['employee_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','employee_name')">{{form['employee_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','leave_type') || $check_field('add','leave_type') || $check_field('set','leave_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="请假类型" prop="leave_type">
								<el-select id="leave_type" v-model="form['leave_type']"
						v-if="user_group === '管理员' || (form['employees_ask_for_leave_id'] && $check_field('set','leave_type')) || (!form['employees_ask_for_leave_id'] && $check_field('add','leave_type'))">
						<el-option v-for="o in list_leave_type" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','leave_type')">{{form['leave_type']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','start_time') || $check_field('add','start_time') || $check_field('set','start_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="开始时间" prop="start_time">
								<el-date-picker :disabled="disabledObj['start_time_isDisabled']" v-if="user_group === '管理员' || (form['employees_ask_for_leave_id'] && $check_field('set','start_time')) || (!form['employees_ask_for_leave_id'] && $check_field('add','start_time'))" id="start_time"
						v-model="form['start_time']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','start_time')">{{form['start_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','end_time') || $check_field('add','end_time') || $check_field('set','end_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="结束时间" prop="end_time">
								<el-date-picker :disabled="disabledObj['end_time_isDisabled']" v-if="user_group === '管理员' || (form['employees_ask_for_leave_id'] && $check_field('set','end_time')) || (!form['employees_ask_for_leave_id'] && $check_field('add','end_time'))" id="end_time"
						v-model="form['end_time']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','end_time')">{{form['end_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','leave_duration') || $check_field('add','leave_duration') || $check_field('set','leave_duration')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="请假时长" prop="leave_duration">
								<el-input-number id="leave_duration" v-model.number="form['leave_duration']"
						v-if="user_group === '管理员' || (form['employees_ask_for_leave_id'] && $check_field('set','leave_duration')) || (!form['employees_ask_for_leave_id'] && $check_field('add','leave_duration'))" :disabled="disabledObj['leave_duration_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','leave_duration')">{{form['leave_duration']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','reason_for_leave') || $check_field('add','reason_for_leave') || $check_field('set','reason_for_leave')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="请假原因" prop="reason_for_leave">
								<el-input type="textarea" id="reason_for_leave" v-model="form['reason_for_leave']" placeholder="请输入请假原因"
						v-if="user_group === '管理员' || (form['employees_ask_for_leave_id'] && $check_field('set','reason_for_leave')) || (!form['employees_ask_for_leave_id'] && $check_field('add','reason_for_leave'))" :disabled="disabledObj['reason_for_leave_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','reason_for_leave')">{{form['reason_for_leave']}}</div>
							</el-form-item>
			</el-col>
							<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核状态" prop="examine_state">
					<el-select id="examine_state" v-model="form['examine_state']"
						v-if="user_group === '管理员' || (form['examine_state'] && $check_examine()) || (!form['examine_state'] && $check_examine())">
						<el-option key="未审核" label="未审核" value="未审核"></el-option>
						<el-option key="已通过" label="已通过" value="已通过"></el-option>
						<el-option key="未通过" label="未通过" value="未通过"></el-option>
					</el-select>
					<div v-else>{{form["examine_state"]}}</div>
				</el-form-item>
			</el-col>
					<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核回复" prop="examine_reply">
					<el-input id="examine_reply" v-model="form['examine_reply']" placeholder="请输入审核回复"
						v-if="user_group === '管理员' || (form['examine_reply'] && $check_examine()) || (!form['examine_reply'] && $check_examine())"></el-input>
					<div v-else>{{form["examine_reply"]}}</div>
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
				field: "employees_ask_for_leave_id",
				url_add: "~/api/employees_ask_for_leave/add?",
				url_set: "~/api/employees_ask_for_leave/set?",
				url_get_obj: "~/api/employees_ask_for_leave/get_obj?",
				url_upload: "~/api/employees_ask_for_leave/upload?",

				query: {
					"employees_ask_for_leave_id": 0,
				},

				form: {
								"employee_no": 0, // 员工工号
										"employee_name":  '', // 员工姓名
										"leave_type":  '', // 请假类型
										"start_time":  '', // 开始时间
										"end_time":  '', // 结束时间
										"leave_duration":  0, // 请假时长
										"reason_for_leave":  '', // 请假原因
									"examine_state": "未审核",
							"examine_reply": "",
							"employees_ask_for_leave_id": 0, // ID
						
				},
				disabledObj:{
								"employee_no_isDisabled": false,
										"employee_name_isDisabled": false,
										"leave_type_isDisabled": false,
										"start_time_isDisabled": false,
										"end_time_isDisabled": false,
					          			"leave_duration_isDisabled": false,
										"reason_for_leave_isDisabled": false,
										},

	
					// 用户列表
				list_user_employee_no: [],
						// 用户组
				group_user_employee_no: "",
				
						// 请假类型选项列表
				list_leave_type: ['病假','事假','其他'],
	
		
		
		
		
	
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
					/**
			 * 获取员工用户组
			 */
			async get_group_user_employee_no() {
							this.form["employee_no"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=员工");
				if(json.result && json.result.obj){
					this.group_user_employee_no = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_employee_no(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_employee_no.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["employee_no"] = id
									_this.disabledObj['employee_no' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "employee_no") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
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
							        if (this.form["start_time"].indexOf("-")===-1){
            this.form["start_time"] = this.$toTime(parseInt(this.form["start_time"]),"yyyy-MM-dd hh:mm:ss")
        }
			        if (this.form["end_time"].indexOf("-")===-1){
            this.form["end_time"] = this.$toTime(parseInt(this.form["end_time"]),"yyyy-MM-dd hh:mm:ss")
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


										        if(this.form["start_time"]=="0000-00-00 00:00:00"){
          this.form["start_time"] = null;
        }
				if(parseInt(this.form["start_time"]) > 9999){
					this.form["start_time"] = this.$toTime(parseInt(this.form["start_time"]),"yyyy-MM-dd hh:mm:ss")
				}
				        if(this.form["end_time"]=="0000-00-00 00:00:00"){
          this.form["end_time"] = null;
        }
				if(parseInt(this.form["end_time"]) > 9999){
					this.form["end_time"] = this.$toTime(parseInt(this.form["end_time"]),"yyyy-MM-dd hh:mm:ss")
				}
									

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
					bl = this.$check_action('/employees_ask_for_leave/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/employees_ask_for_leave/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/employees_ask_for_leave/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/employees_ask_for_leave/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/employees_ask_for_leave/view','get');
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
					this.get_group_user_employee_no();
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

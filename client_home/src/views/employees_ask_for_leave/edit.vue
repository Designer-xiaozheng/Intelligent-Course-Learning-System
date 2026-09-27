<template>
	<div class="diy_edit page_employees_ask_for_leave" id="employees_ask_for_leave_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row diy_edit_content_box'>
						<div v-if="$check_field('set','employee_no') || $check_field('add','employee_no') || $check_field('get','employee_no')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								员工工号:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_employee_no" :disabled="disabledObj['employee_no_isDisabled']" v-model="form['employee_no']" v-if="(form['employee_no'] && $check_field('set','employee_no')) || (!form['employee_no'] && $check_field('add','employee_no'))" >
								<option v-for="o in list_user_employee_no" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','employee_no')">{{ form['employee_no'] }}</span>
						</div>
					</div>
							<div v-if="$check_field('set','employee_name') || $check_field('add','employee_name') || $check_field('get','employee_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								员工姓名:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_employee_name" v-model="form['employee_name']" placeholder="请输入员工姓名" v-if="(form['employee_name'] && $check_field('set','employee_name')) || (!form['employee_name'] && $check_field('add','employee_name'))"  :disabled="disabledObj['employee_name_isDisabled']"/>
							<span v-else-if="$check_field('get','employee_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','leave_type') || $check_field('add','leave_type') || $check_field('get','leave_type')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								请假类型:
							</span>
						</div>
								<!-- 选项 -->
						<div class="diy_field diy_down">
							<select id="form_leave_type" v-model="form['leave_type']" v-if="(form['leave_type'] && $check_field('set','leave_type')) || (!form['leave_type'] && $check_field('add','leave_type'))" >
								<option v-for="o in list_leave_type" :value="o">
									{{o}}
								</option>
							</select>
							<span v-else-if="$check_field('get','leave_type')">{{ form['leave_type'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','start_time') || $check_field('add','start_time') || $check_field('get','start_time')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								开始时间:
							</span>
						</div>
								<!-- 日长 -->
						<div class="diy_field diy_datetime">
							<input type="datetime-local" :disabled="disabledObj['start_time_isDisabled']" id="form_start_time" v-model="form['start_time']" placeholder="请输入开始时间" v-if="(form['start_time'] && $check_field('set','start_time')) || (!form['start_time'] && $check_field('add','start_time'))" />
							<span v-else-if="$check_field('get','start_time')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','end_time') || $check_field('add','end_time') || $check_field('get','end_time')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								结束时间:
							</span>
						</div>
								<!-- 日长 -->
						<div class="diy_field diy_datetime">
							<input type="datetime-local" :disabled="disabledObj['end_time_isDisabled']" id="form_end_time" v-model="form['end_time']" placeholder="请输入结束时间" v-if="(form['end_time'] && $check_field('set','end_time')) || (!form['end_time'] && $check_field('add','end_time'))" />
							<span v-else-if="$check_field('get','end_time')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','leave_duration') || $check_field('add','leave_duration') || $check_field('get','leave_duration')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								请假时长:
							</span>
						</div>
								<!-- 数字 -->
						<div class="diy_field diy_number">
							<input type="number" id="form_leave_duration" v-model.number="form['leave_duration']" placeholder="请输入请假时长" v-if="(form['leave_duration'] && $check_field('set','leave_duration')) || (!form['leave_duration'] && $check_field('add','leave_duration'))" :disabled="disabledObj['leave_duration_isDisabled']" />
							<span v-else-if="$check_field('get','leave_duration')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','reason_for_leave') || $check_field('add','reason_for_leave') || $check_field('get','reason_for_leave')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								请假原因:
							</span>
						</div>
								<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_reason_for_leave" v-model="form['reason_for_leave']" v-if="(form['reason_for_leave'] && $check_field('set','reason_for_leave')) || (!form['reason_for_leave'] && $check_field('add','reason_for_leave'))" :disabled="disabledObj['reason_for_leave_isDisabled']" />
							<span v-else-if="$check_field('get','reason_for_leave')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
	


					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核状态:
							</span>
						</div>
						<div class="diy_field diy_select" v-if="$check_action('/employees_ask_for_leave/edit','examine')">
							<!--<span> {{ form['examine_state'] }} </span>-->
							<select v-model="form['examine_state']">
								<option value="未审核">
									未审核
								</option>
								<option value="已通过">
									已通过
								</option>
								<option value="未通过">
									未通过
								</option>
							</select>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_state'] }}
							</span>
						</div>
					</div>
					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核回复:
							</span>
						</div>
						<div class="diy_field diy_desc" v-if="$check_action('/employees_ask_for_leave/edit','examine')">
							<textarea v-model="form['examine_reply']"></textarea>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_reply'] }}
							</span>
						</div>
					</div>


				</div>
				<div class="diy_edit_submit_box row">
					<div class="col-12">
						<div class="btn_box">
							<button class="btn_submit" @click="submit()">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				url_get_obj: "~/api/employees_ask_for_leave/get_obj?",
				url_add: "~/api/employees_ask_for_leave/add?",
				url_set: "~/api/employees_ask_for_leave/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
						"employee_no": 0,
							"employee_name": "",
							"leave_type": "",
							"start_time": "",
							"end_time": "",
							"leave_duration": 0,
							"reason_for_leave": "",
						"employees_ask_for_leave_id": 0,
				},

				obj: {
						"employee_no": 0, // 员工工号
							"employee_name":  '', // 员工姓名
							"leave_type":  '', // 请假类型
							"start_time": new Date().getTime(),
							"end_time": new Date().getTime(),
							"leave_duration":  0, // 请假时长
							"reason_for_leave":  '', // 请假原因
						"examine_state": "未审核",
					"examine_reply": "",
					"employees_ask_for_leave_id": 0,
				},

				// 表单字段
				form: {
						"employee_no": 0, // 员工工号
							"employee_name":  '', // 员工姓名
							"leave_type":  '', // 请假类型
							"start_time": new Date().getTime(),
							"end_time": new Date().getTime(),
							"leave_duration":  0, // 请假时长
							"reason_for_leave":  '', // 请假原因
						"examine_state": "未审核",
					"examine_reply": "",
					"employees_ask_for_leave_id": 0,
				},
				disabledObj:{
						"employee_no_isDisabled": false,
							"employee_name_isDisabled": false,
							"leave_type_isDisabled": false,
							"start_time_isDisabled": false,
							"end_time_isDisabled": false,
									"reason_for_leave_isDisabled": false,
					},

						// 用户列表
				list_user_employee_no: [],
								// 请假类型选项列表
				list_leave_type: ['病假','事假','其他'],
										
				// ID字段
				field: "employees_ask_for_leave_id",

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
					async get_user_session_employee_no(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=员工");
				if(json.result && json.result.obj){
					var source_table = json.result.obj.source_table;
					var user_id = _this.$store.state.user.user_id;
					if (user_id){
						var url = "~/api/"+source_table+"/get_obj?"
						this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
							if (res.result && res.result.obj) {
								var arr = []
								for (let key in res.result.obj) {
									arr.push(key)
								}
								var arrForm = []
								for (let key in _this.form) {
									arrForm.push(key)
								}
								_this.form["employee_no"] = user_id
								_this.disabledObj['employee_no' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
                  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                    for (var j = 0; j < arrForm.length; j++) {
                      if (arr[i] === arrForm[j]) {
                        if (arr[i] !== "employee_no") {
                          _this.form[arrForm[j]] = res.result.obj[arr[i]]
                          _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                          break;
                        }
                      }
                    }
                  }
								}
							}
						});
					}
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
				
				
				
				
				
				
	
			/**
			 * 修改文件
			 * @param { Object } files 上传文件对象
			 * @param { String } str 表单的属性名
			 */
			change_file(files, str) {
				var form = new FormData();
				form.append("file", files[0]);
				this.$post("~/api/employees_ask_for_leave/upload?", form, (res) => {
					if (res.result) {
						this.form[str] = res.result.url;
					} else if (res.error) {
						this.$toast(res.error.message);
					}
				});
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_before(param){
				var form = $.db.get("form");
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
        //   this.obj = $.push(this.obj ,form);
				// 	this.form = $.push(this.form ,form);
				// }
				// var arr = []
				// for (let key in form) {
				// 	arr.push(key)
				// }
				// for (var i=0;i<arr.length;i++){
				// 	this.disabledObj[arr[i] + '_isDisabled'] = true
				// }
        if (form) {
          var arr = []
          for (let key in form) {
            arr.push(key)
          }
          var arrForm = []
          for (let key in this.form) {
            arrForm.push(key)
          }
          for (var i=0;i<arr.length;i++){
            if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
              for (var j = 0; j < arrForm.length; j++) {
                if (arrForm[j] === arr[i]) {
                  this.form[arrForm[j]] = form[arr[i]]
                  this.obj[arrForm[j]] = form[arr[i]]
                  this.disabledObj[arrForm[j] + '_isDisabled'] = true
                  break;
                }
              }
            }
          }
        }
							        if (JSON.stringify(this.form["start_time"]).indexOf("-")===-1) {
          this.form["start_time"] = this.$toTime(parseInt(this.form["start_time"]), "yyyy-MM-ddThh:mm")
        }
			        if (JSON.stringify(this.form["end_time"]).indexOf("-")===-1) {
          this.form["end_time"] = this.$toTime(parseInt(this.form["end_time"]), "yyyy-MM-ddThh:mm")
        }
						
        $.db.del("form");
				return param;
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json ,func){
				// var form = $.db.get("form");
				// var obj = Object.assign({} ,form ,this.obj);
				// if (obj) {
        //   delete(obj.examine_state)
        //   delete(obj.examine_reply)
				// 	this.obj = $.push(this.obj ,obj);
				// }
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
				// 	this.form = $.push(this.form ,form);
				// }
				if(func){
					func(json);
				}
			},

		},
		created() {
					this.get_user_session_employee_no();
					this.get_list_user_employee_no();
																					},
	}
</script>

<style>




</style>

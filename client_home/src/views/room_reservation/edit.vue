<template>
	<div class="diy_edit page_room_reservation" id="room_reservation_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row diy_edit_content_box'>
						<div v-if="$check_field('set','room_name') || $check_field('add','room_name') || $check_field('get','room_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								房间名称:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_room_name" v-model="form['room_name']" placeholder="请输入房间名称" v-if="(form['room_name'] && $check_field('set','room_name')) || (!form['room_name'] && $check_field('add','room_name'))"  :disabled="disabledObj['room_name_isDisabled']"/>
							<span v-else-if="$check_field('get','room_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','room_type') || $check_field('add','room_type') || $check_field('get','room_type')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								房间类型:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_room_type" v-model="form['room_type']" placeholder="请输入房间类型" v-if="(form['room_type'] && $check_field('set','room_type')) || (!form['room_type'] && $check_field('add','room_type'))"  :disabled="disabledObj['room_type_isDisabled']"/>
							<span v-else-if="$check_field('get','room_type')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','price') || $check_field('add','price') || $check_field('get','price')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								价格:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_price" v-model="form['price']" placeholder="请输入价格" v-if="(form['price'] && $check_field('set','price')) || (!form['price'] && $check_field('add','price'))"  :disabled="disabledObj['price_isDisabled']"/>
							<span v-else-if="$check_field('get','price')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','user') || $check_field('add','user') || $check_field('get','user')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								用户:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_user" :disabled="disabledObj['user_isDisabled']" v-model="form['user']" v-if="(form['user'] && $check_field('set','user')) || (!form['user'] && $check_field('add','user'))" >
								<option v-for="o in list_user_user" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','user')">{{ form['user'] }}</span>
						</div>
					</div>
							<div v-if="$check_field('set','user_name') || $check_field('add','user_name') || $check_field('get','user_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								用户姓名:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_user_name" v-model="form['user_name']" placeholder="请输入用户姓名" v-if="(form['user_name'] && $check_field('set','user_name')) || (!form['user_name'] && $check_field('add','user_name'))"  :disabled="disabledObj['user_name_isDisabled']"/>
							<span v-else-if="$check_field('get','user_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','contact_number') || $check_field('add','contact_number') || $check_field('get','contact_number')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								联系电话:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_contact_number" v-model="form['contact_number']" placeholder="请输入联系电话" v-if="(form['contact_number'] && $check_field('set','contact_number')) || (!form['contact_number'] && $check_field('add','contact_number'))"  :disabled="disabledObj['contact_number_isDisabled']"/>
							<span v-else-if="$check_field('get','contact_number')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','reservation_time') || $check_field('add','reservation_time') || $check_field('get','reservation_time')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								预订时间:
							</span>
						</div>
								<!-- 日长 -->
						<div class="diy_field diy_datetime">
							<input type="datetime-local" :disabled="disabledObj['reservation_time_isDisabled']" id="form_reservation_time" v-model="form['reservation_time']" placeholder="请输入预订时间" v-if="(form['reservation_time'] && $check_field('set','reservation_time')) || (!form['reservation_time'] && $check_field('add','reservation_time'))" />
							<span v-else-if="$check_field('get','reservation_time')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','booking_quantity') || $check_field('add','booking_quantity') || $check_field('get','booking_quantity')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								预订数量:
							</span>
						</div>
								<!-- 选项 -->
						<div class="diy_field diy_down">
							<select id="form_booking_quantity" v-model="form['booking_quantity']" v-if="(form['booking_quantity'] && $check_field('set','booking_quantity')) || (!form['booking_quantity'] && $check_field('add','booking_quantity'))" >
								<option v-for="o in list_booking_quantity" :value="o">
									{{o}}
								</option>
							</select>
							<span v-else-if="$check_field('get','booking_quantity')">{{ form['booking_quantity'] }}</span>
						</div>
							</div>
	


					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核状态:
							</span>
						</div>
						<div class="diy_field diy_select" v-if="$check_action('/room_reservation/edit','examine')">
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
						<div class="diy_field diy_desc" v-if="$check_action('/room_reservation/edit','examine')">
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
				url_get_obj: "~/api/room_reservation/get_obj?",
				url_add: "~/api/room_reservation/add?",
				url_set: "~/api/room_reservation/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
						"room_name": "",
							"room_type": "",
							"price": "",
							"user": 0,
							"user_name": "",
							"contact_number": "",
							"reservation_time": "",
							"booking_quantity": "",
						"room_reservation_id": 0,
				},

				obj: {
						"room_name":  '', // 房间名称
							"room_type":  '', // 房间类型
							"price":  '', // 价格
							"user": 0, // 用户
							"user_name":  '', // 用户姓名
							"contact_number":  '', // 联系电话
							"reservation_time": new Date().getTime(),
							"booking_quantity":  '', // 预订数量
						"examine_state": "未审核",
					"examine_reply": "",
					"room_reservation_id": 0,
				},

				// 表单字段
				form: {
						"room_name":  '', // 房间名称
							"room_type":  '', // 房间类型
							"price":  '', // 价格
							"user": 0, // 用户
							"user_name":  '', // 用户姓名
							"contact_number":  '', // 联系电话
							"reservation_time": new Date().getTime(),
							"booking_quantity":  '', // 预订数量
						"examine_state": "未审核",
					"examine_reply": "",
					"room_reservation_id": 0,
				},
				disabledObj:{
						"room_name_isDisabled": false,
							"room_type_isDisabled": false,
							"price_isDisabled": false,
							"user_isDisabled": false,
							"user_name_isDisabled": false,
							"contact_number_isDisabled": false,
							"reservation_time_isDisabled": false,
							"booking_quantity_isDisabled": false,
					},

												// 用户列表
				list_user_user: [],
												// 预订数量选项列表
				list_booking_quantity: ['1'],
		
				// ID字段
				field: "room_reservation_id",

			}
		},
		methods: {
			
				
				
						/**
			 * 获取注册用户用户列表
			 */
			async get_list_user_user() {
				// if(this.user_group !== "管理员" && this.form["user"] === 0) {
				//     this.form["user"] = this.user.user_id;
				// }
				var json = await this.$get("~/api/user/get_list?user_group=注册用户");
				if(json.result && json.result.list){
					this.list_user_user = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
					async get_user_session_user(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=注册用户");
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
								_this.form["user"] = user_id
								_this.disabledObj['user' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
                  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                    for (var j = 0; j < arrForm.length; j++) {
                      if (arr[i] === arrForm[j]) {
                        if (arr[i] !== "user") {
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
				this.$post("~/api/room_reservation/upload?", form, (res) => {
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
													        if (JSON.stringify(this.form["reservation_time"]).indexOf("-")===-1) {
          this.form["reservation_time"] = this.$toTime(parseInt(this.form["reservation_time"]), "yyyy-MM-ddThh:mm")
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
														this.get_user_session_user();
					this.get_list_user_user();
															},
	}
</script>

<style>




</style>

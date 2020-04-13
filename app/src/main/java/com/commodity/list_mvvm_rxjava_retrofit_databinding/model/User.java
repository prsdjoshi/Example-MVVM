/**
 * Copyright 2016 Erik Jhordan Rey.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.commodity.list_mvvm_rxjava_retrofit_databinding.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

  @SerializedName("gender") public String gender;

  @SerializedName("name") public String name;

  @SerializedName("location") public String location;

  @SerializedName("email") public String mail;

  @SerializedName("login") public String login;

  @SerializedName("phone") public String phone;

  @SerializedName("cell") public String cell;

  @SerializedName("picture") public String picture;

  public String fullName;

  public boolean hasEmail() {
    return mail != null && !mail.isEmpty();
  }
}
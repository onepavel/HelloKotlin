/*
 * Copyright (C) 2017 Olmo Gallegos Hernández.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.voghdev.hellokotlin.features.user.datasource

import com.raizlabs.android.dbflow.sql.language.SQLite
import es.voghdev.hellokotlin.features.user.User
import es.voghdev.hellokotlin.features.user.UserDBEntry
import es.voghdev.hellokotlin.features.user.usecase.GetUsers

class GetUsersDBDataSource : GetUsers {
    override fun getUsers(): List<User> {
        return SQLite.select().from(UserDBEntry::class.java).queryList().map { it.toDomain() }
    }
}
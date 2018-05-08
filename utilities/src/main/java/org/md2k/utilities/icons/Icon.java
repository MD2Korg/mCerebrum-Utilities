/*
 * Copyright (c) 2018, The University of Memphis, MD2K Center of Excellence
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.md2k.utilities.icons;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;

/**
 * Provides methods for getting icons and enumeration classes for <code>Size</code> and <code>Id</code>.
 */
public class Icon {
    /**
     * Returns the icon specified by the given parameters.
     * @param context Android context
     * @param id Id of the desired icon
     * @param color Color of the icon
     * @param size Size of the icon
     * @return The icon specified by the given parameters.
     */
    public static Drawable get(Context context, Id id, int color, Size size){
        return new IconicsDrawable(context).icon(id.value).color(color).sizeDp(size.value).paddingDp(16);
    }

    /**
     * Returns the icon specified by the given parameters.
     * @param context Android context
     * @param name Name of the desired icon
     * @param color Color of the icon
     * @param size Size of the icon
     * @return The icon specified by the given parameters.
     */
    public static Drawable get(Context context, String name, int color, Size size){
        Drawable icon = null;
        if(name.startsWith("faw")){
            icon = new IconicsDrawable(context)
                    .icon(FontAwesome.Icon.valueOf(name))
                    .color(color)
                    .sizeDp(size.value)
                    .paddingDp(16);
        } else if(name.startsWith("gmd")){
            icon = new IconicsDrawable(context)
                    .icon(GoogleMaterial.Icon.valueOf(name))
                    .color(color)
                    .sizeDp(size.value)
                    .paddingDp(16);
        }
        return icon;
    }

    /**
     * Defines several <code>Size</code> values.
     * <ul>
     *     <li><code>EXTRA_SMALL</code> = 12</li>
     *     <li><code>SMALL</code> = 24</li>
     *     <li><code>MEDIUM</code> = 48</li>
     *     <li><code>LARGE</code> = 72</li>
     *     <li><code>EXTRA_LARGE</code> = 96</li>
     * </ul>
     */
    public enum Size {
        EXTRA_SMALL(12), SMALL(24), MEDIUM(48), LARGE(72), EXTRA_LARGE(96);
        private int value;
        private Size(int value){
            this.value = value;
        }
    }

    /**
     * Defines several <code>Id</code> values.
     * <ul>
     *     <li><code>ABOUT</code></li>
     *     <li><code>BLUETOOTH</code></li>
     *     <li><code>BUG</code></li>
     *     <li><code>CHECK</code></li>
     *     <li><code>CHECK_CIRCLE</code></li>
     *     <li><code>COPYRIGHT</code></li>
     *     <li><code>DESCRIPTION</code></li>
     *     <li><code>ERROR_CIRCLE</code></li>
     *     <li><code>GITHUB</code></li>
     *     <li><code>HOME</code></li>
     *     <li><code>INFO_CIRCLE</code></li>
     *     <li><code>OK_CIRCLE</code></li>
     *     <li><code>POWER</code></li>
     *     <li><code>QUESTION_CIRCLE</code></li>
     *     <li><code>REFRESH</code></li>
     *     <li><code>SEARCH</code></li>
     *     <li><code>SUCCESS_CIRCLE</code></li>
     *     <li><code>USER</code></li>
     *     <li><code>WARNING_TRIANGLE</code></li>
     *     <li><code>EATING</code></li>
     *     <li><code>SMOKING</code></li>
     * </ul>
     */
    public enum Id {
        ABOUT(FontAwesome.Icon.faw_info_circle),
        BLUETOOTH(FontAwesome.Icon.faw_bluetooth),
        BUG(FontAwesome.Icon.faw_bug),
        CHECK(FontAwesome.Icon.faw_check),
        CHECK_CIRCLE(FontAwesome.Icon.faw_check_circle),
        COPYRIGHT(FontAwesome.Icon.faw_copyright),
        DESCRIPTION(FontAwesome.Icon.faw_file_text_o),
        ERROR_CIRCLE(FontAwesome.Icon.faw_times_circle),
        GITHUB(FontAwesome.Icon.faw_github),
        HOME(FontAwesome.Icon.faw_home),
        INFO_CIRCLE(FontAwesome.Icon.faw_info_circle),
        OK_CIRCLE(FontAwesome.Icon.faw_check_circle),
        POWER(FontAwesome.Icon.faw_power_off),
        QUESTION_CIRCLE(FontAwesome.Icon.faw_question_circle),
        REFRESH(FontAwesome.Icon.faw_refresh),
        SEARCH(FontAwesome.Icon.faw_search),
        SUCCESS_CIRCLE(FontAwesome.Icon.faw_check_circle),
        USER(FontAwesome.Icon.faw_user),
        WARNING_TRIANGLE(FontAwesome.Icon.faw_exclamation_triangle),
        EATING(GoogleMaterial.Icon.gmd_local_dining),
        SMOKING(GoogleMaterial.Icon.gmd_smoking_rooms);
        private IIcon value;
        private Id(IIcon value){
            this.value = value;
        }
    }
}

<template>

    <v-data-table
        :headers="headers"
        :items="gpsInfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'GpsInfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "time", value: "time" },
                { text: "x", value: "x" },
                { text: "y", value: "y" },
                { text: "phoneId", value: "phoneId" },
            ],
            gpsInfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/gpsInfos'))

            temp.data._embedded.gpsInfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.gpsInfo = temp.data._embedded.gpsInfos;
        },
        methods: {
        }
    }
</script>


using herlivre_api.Models;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Herlivre_api.Models
{
    [Table("Voo")]
    public class Voo
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [ForeignKey("id_cidade")]
        public Cidade Cidade { get; set; }

        [StringLength(50)]
        public string Local_partida { get; set; }

        [StringLength(50)]
        public string Companhia { get; set; }

        [StringLength(10)]
        public string Num_voo { get; set; }

        [StringLength(2)]
        public string Num_assento { get; set; }

        public int Qtd_assentos_disp { get; set; }

        public string Data_partida { get; set; }

        public string Data_chegada { get; set; }

    }
}

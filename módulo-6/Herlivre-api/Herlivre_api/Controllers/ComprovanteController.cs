using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Herlivre_api.Models;
using herlivre_api.Models;

namespace Herlivre_api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ComprovanteController : ControllerBase
    {
        private readonly GeralDbContext _context;

        public ComprovanteController(GeralDbContext context)
        {
            _context = context;
        }

        // GET: api/Comprovante
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Comprovante>>> GetComprovantes()
        {
            return await _context.Comprovantes.ToListAsync();
        }

        // GET: api/Comprovante/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Comprovante>> GetComprovante(long id)
        {
            var comprovante = await _context.Comprovantes.FindAsync(id);

            if (comprovante == null)
            {
                return NotFound();
            }

            return comprovante;
        }

        // PUT: api/Comprovante/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutComprovante(long id, Comprovante comprovante)
        {
            if (id != comprovante.Id)
            {
                return BadRequest();
            }

            _context.Entry(comprovante).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ComprovanteExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Comprovante
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Comprovante>> PostComprovante(Comprovante comprovante)
        {
            _context.Comprovantes.Add(comprovante);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetComprovante", new { id = comprovante.Id }, comprovante);
        }

        // DELETE: api/Comprovante/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteComprovante(long id)
        {
            var comprovante = await _context.Comprovantes.FindAsync(id);
            if (comprovante == null)
            {
                return NotFound();
            }

            _context.Comprovantes.Remove(comprovante);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool ComprovanteExists(long id)
        {
            return _context.Comprovantes.Any(e => e.Id == id);
        }
    }
}
